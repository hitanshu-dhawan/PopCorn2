package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.network.MoviesService

class MoviesRepository(private val moviesService: MoviesService) {

//    suspend fun getNowPlayingMovies(): List<MovieBriefJson> {
//        return moviesService.getNowPlayingMovies().results
//    }

//    suspend fun getPopularMovies(): List<MovieBriefJson> {
//        return moviesService.getPopularMovies().results
//    }

    //...

    fun getNowPlayingMovies() = liveData {
        emit(moviesService.getNowPlayingMovies().results)
    }

    fun getPopularMovies() = liveData {
        emit(moviesService.getPopularMovies().results)
    }

    fun getUpcomingMovies() = liveData {
        emit(moviesService.getUpcomingMovies().results)
    }

    fun getTopRatedMovies() = liveData {
        emit(moviesService.getTopRatedMovies().results)
    }

    //...

}