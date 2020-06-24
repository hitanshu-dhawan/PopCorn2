package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface MoviesUseCases {

    suspend fun getNowPlayingMovies(): Resource<List<ShowData>>

    suspend fun getPopularMovies(): Resource<List<ShowData>>

    suspend fun getUpcomingMovies(): Resource<List<ShowData>>

    suspend fun getTopRatedMovies(): Resource<List<ShowData>>

}
