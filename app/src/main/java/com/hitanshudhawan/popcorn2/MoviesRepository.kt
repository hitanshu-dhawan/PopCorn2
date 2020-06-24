package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface MoviesRepository {

    suspend fun getNowPlayingMovies(page: Int = 1): Resource<List<MovieBrief>>

    suspend fun getPopularMovies(page: Int = 1): Resource<List<MovieBrief>>

    suspend fun getUpcomingMovies(page: Int = 1): Resource<List<MovieBrief>>

    suspend fun getTopRatedMovies(page: Int = 1): Resource<List<MovieBrief>>

}
