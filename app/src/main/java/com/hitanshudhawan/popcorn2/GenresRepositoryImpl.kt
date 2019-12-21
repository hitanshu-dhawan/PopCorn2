package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.cache.GenresDao
import com.hitanshudhawan.popcorn2.database.cache.MovieGenreEntity
import com.hitanshudhawan.popcorn2.database.cache.TVShowGenreEntity
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val genresDao: GenresDao
) : GenresRepository {

    // hitanshu : make something like NetworkBoundResource
    // or use libraries like Store : https://github.com/dropbox/Store
    // hitanshu : wrong logic, not storing latest genres from network
    override fun getMovieGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getMovieGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.map { Genre(it.id, it.name) }))
        } else {
            val response = safe { genresService.getMovieGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertMovieGenres(response.body()!!.genres.map { MovieGenreEntity(it.id, it.name) })
                emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
            } else {
                emit(Resource.Error())
            }
        }
    }

    // hitanshu : make something like NetworkBoundResource
    // or use libraries like Store : https://github.com/dropbox/Store
    // hitanshu : wrong logic, not storing latest genres from network
    override fun getTVShowGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getTVShowGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.map { Genre(it.id, it.name) }))
        } else {
            val response = safe { genresService.getTVShowGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertTVShowGenres(response.body()!!.genres.map { TVShowGenreEntity(it.id, it.name) })
                emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
            } else {
                emit(Resource.Error())
            }
        }
    }

}