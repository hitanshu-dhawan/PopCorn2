package com.hitanshudhawan.popcorn2

interface GenresRepository {

    suspend fun getMovieGenres(): Resource<List<Genre>>

    suspend fun getTVShowGenres(): Resource<List<Genre>>

}
