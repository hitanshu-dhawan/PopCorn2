package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.network.models.GenresJson
import retrofit2.Response
import retrofit2.http.GET

interface GenresService {

    @GET("genre/movie/list")
    suspend fun getMovieGenres(): Response<GenresJson>

    @GET("genre/tv/list")
    suspend fun getTVShowGenres(): Response<GenresJson>

}