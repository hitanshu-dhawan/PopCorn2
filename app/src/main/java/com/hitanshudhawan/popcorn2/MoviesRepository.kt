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
        emit(moviesService.getNowPlayingMovies().results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
    }

    fun getPopularMovies() = liveData {
        emit(moviesService.getPopularMovies().results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
    }

    fun getUpcomingMovies() = liveData {
        emit(moviesService.getUpcomingMovies().results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
    }

    fun getTopRatedMovies() = liveData {
        emit(moviesService.getTopRatedMovies().results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
    }

    //...

}