package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.cache.GenresDao
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val genresDao: GenresDao
) : GenresRepository {

    // hitanshu : make something like NetworkBoundResource
    // or use libraries like Store : https://github.com/dropbox/Store
    override fun getMovieGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getMovieGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.mapToGenres()))
            val response = safe { genresService.getMovieGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertMovieGenres(response.body()!!.genres.mapToMovieGenreEntities())
            }
        } else {
            val response = safe { genresService.getMovieGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertMovieGenres(response.body()!!.genres.mapToMovieGenreEntities())
                emit(Resource.Success(response.body()!!.genres.mapToGenres()))
            } else {
                emit(Resource.Error())
            }
        }
    }

    // hitanshu : make something like NetworkBoundResource
    // or use libraries like Store : https://github.com/dropbox/Store
    override fun getTVShowGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val genreEntities = genresDao.getTVShowGenres()
        if (genreEntities.isNotEmpty()) {
            emit(Resource.Success(genreEntities.mapToGenres()))
            val response = safe { genresService.getTVShowGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertTVShowGenres(response.body()!!.genres.mapToTVShowGenreEntities())
            }
        } else {
            val response = safe { genresService.getTVShowGenres() }
            if (response != null && response.isSuccessful) {
                genresDao.insertTVShowGenres(response.body()!!.genres.mapToTVShowGenreEntities())
                emit(Resource.Success(response.body()!!.genres.mapToGenres()))
            } else {
                emit(Resource.Error())
            }
        }
    }

}
