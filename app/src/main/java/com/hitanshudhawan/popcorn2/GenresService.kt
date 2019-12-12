package com.hitanshudhawan.popcorn2

import retrofit2.http.GET

interface GenresService {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): GenresJsonResponse

    @GET("genre/tv/list")
    suspend fun getTVShowGenres(): GenresJsonResponse

}