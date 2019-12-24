package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface MoviesRepository {

    fun getNowPlayingMovies(): LiveData<Resource<List<MovieBrief>>>

    fun getPopularMovies(): LiveData<Resource<List<MovieBrief>>>

    fun getUpcomingMovies(): LiveData<Resource<List<MovieBrief>>>

    fun getTopRatedMovies(): LiveData<Resource<List<MovieBrief>>>

    fun isFavoriteMovie(id: Int): LiveData<Boolean>

    suspend fun toggleFavoriteMovie(movieBrief: MovieBrief)

}
