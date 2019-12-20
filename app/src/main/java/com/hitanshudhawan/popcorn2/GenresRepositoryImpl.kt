package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.GenresDao
import com.hitanshudhawan.popcorn2.database.MovieGenreEntity
import com.hitanshudhawan.popcorn2.database.TVShowGenreEntity
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val genresDao: GenresDao
) : GenresRepository {

    // hitanshu : make something like NetworkBoundResource
    override fun getMovieGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getMovieGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.map { Genre(it.id, it.name) }))
        } else {
            val response = genresService.getMovieGenres()
            if (response.isSuccessful) {
                genresDao.insertMovieGenres(response.body()!!.genres.map { MovieGenreEntity(it.id, it.name) })
                emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
            } else {
                emit(Resource.Error())
            }
        }
    }

    // hitanshu : make something like NetworkBoundResource
    override fun getTVShowGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getTVShowGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.map { Genre(it.id, it.name) }))
        } else {
            val response = genresService.getTVShowGenres()
            if (response.isSuccessful) {
                genresDao.insertTVShowGenres(response.body()!!.genres.map { TVShowGenreEntity(it.id, it.name) })
                emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
            } else {
                emit(Resource.Error())
            }
        }
    }

}