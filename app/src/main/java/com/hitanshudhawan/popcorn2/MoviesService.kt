package com.hitanshudhawan.popcorn2

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int): MoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("page") page: Int): MoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("id") movieId: Int): MovieResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path("id") movieId: Int): VideosResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path("id") movieId: Int): CreditsResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(@Path("id") movieId: Int): MoviesResponse

}