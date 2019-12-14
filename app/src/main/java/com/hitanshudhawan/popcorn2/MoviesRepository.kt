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
        val response = moviesService.getNowPlayingMovies()
        if (response.isSuccessful) {
            emit(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
        }
    }

    fun getPopularMovies() = liveData {
        val response = moviesService.getPopularMovies()
        if (response.isSuccessful) {
            emit(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
        }
    }

    fun getUpcomingMovies() = liveData {
        val response = moviesService.getUpcomingMovies()
        if (response.isSuccessful) {
            emit(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
        }
    }

    fun getTopRatedMovies() = liveData {
        val response = moviesService.getTopRatedMovies()
        if (response.isSuccessful) {
            emit(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids.map { it.toString() }) })
        }
    }

    //...

}