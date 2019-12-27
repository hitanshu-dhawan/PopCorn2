package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.data.CreditsResponse
import com.hitanshudhawan.popcorn2.data.MovieResponse
import com.hitanshudhawan.popcorn2.data.MoviesResponse
import com.hitanshudhawan.popcorn2.data.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int = 1): MoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int = 1): MoviesResponse

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("page") page: Int = 1): MoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int = 1): MoviesResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Int): MovieResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideos(@Path("movie_id") movieId: Int): VideosResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(@Path("movie_id") movieId: Int): CreditsResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getSimilarMovies(@Path("movie_id") movieId: Int): MoviesResponse

}