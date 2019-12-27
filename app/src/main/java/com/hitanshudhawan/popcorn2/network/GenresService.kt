package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.data.GenresResponse
import retrofit2.http.GET

interface GenresService {

    @GET("genre/movie/list")
    fun getMovieGenres(): GenresResponse

    @GET("genre/tv/list")
    fun getTVShowGenres(): GenresResponse

}