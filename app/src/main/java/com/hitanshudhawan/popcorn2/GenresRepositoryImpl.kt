package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.GenresDao
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val genresDao: GenresDao
) : GenresRepository {

    override fun getMovieGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val response = genresService.getMovieGenres()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
        } else {
            emit(Resource.Error())
        }
    }

    override fun getTVShowGenres() = liveData<Resource<List<Genre>>> {
        emit(Resource.Loading())
        val response = genresService.getTVShowGenres()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.genres.map { Genre(it.id, it.name) }))
        } else {
            emit(Resource.Error())
        }
    }

}