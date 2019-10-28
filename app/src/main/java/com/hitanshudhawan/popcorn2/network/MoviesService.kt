package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.network.models.MoviesResponse
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/now_playing" + "?api_key=460c0511e1ef5e2eca8734c04a5fb842")
    suspend fun getNowShowingMovies(): MoviesResponse

    @GET("movie/popular" + "?page=1&region=US&api_key=460c0511e1ef5e2eca8734c04a5fb842")
    suspend fun getPopularMovies(): MoviesResponse

    @GET("movie/upcoming" + "?page=1&region=US&api_key=460c0511e1ef5e2eca8734c04a5fb842")
    suspend fun getUpcomingMovies(): MoviesResponse

    @GET("movie/top_rated" + "?page=1&region=US&api_key=460c0511e1ef5e2eca8734c04a5fb842")
    suspend fun getTopRatedMovies(): MoviesResponse

}