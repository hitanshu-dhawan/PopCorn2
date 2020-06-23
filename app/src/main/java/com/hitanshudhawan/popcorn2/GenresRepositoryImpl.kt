package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService
) : GenresRepository {

    override suspend fun getMovieGenres(): Resource<List<Genre>> {
        val response = safe { genresService.getMovieGenres() }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToGenres())
        else
            return Resource.Error()
    }

    override suspend fun getTVShowGenres(): Resource<List<Genre>> {
        val response = safe { genresService.getTVShowGenres() }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToGenres())
        else
            return Resource.Error()
    }

}
