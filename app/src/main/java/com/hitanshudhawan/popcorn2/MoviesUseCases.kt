package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface MoviesUseCases {

    fun getNowPlayingMovies(): LiveData<Resource<List<ShowData>>>

    fun getPopularMovies(): LiveData<Resource<List<ShowData>>>

    fun getUpcomingMovies(): LiveData<Resource<List<ShowData>>>

    fun getTopRatedMovies(): LiveData<Resource<List<ShowData>>>

    fun isFavoriteMovie(id: Int): LiveData<Boolean>

    suspend fun toggleFavoriteMovie(showData: ShowData)

}
