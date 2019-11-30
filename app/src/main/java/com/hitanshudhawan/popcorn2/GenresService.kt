package com.hitanshudhawan.popcorn2

import retrofit2.http.GET

interface GenresService {

    @GET("genre/movie/list")
    fun getMovieGenres(): GenresResponse

    @GET("genre/tv/list")
    fun getTVShowGenres(): GenresResponse

}