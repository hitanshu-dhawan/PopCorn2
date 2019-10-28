package com.hitanshudhawan.popcorn2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hitanshudhawan.popcorn2.network.ApiClient
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val nowShowingMovies = async { ApiClient.client.create(MoviesService::class.java).getNowShowingMovies() }
            val popularMovies = async { ApiClient.client.create(MoviesService::class.java).getPopularMovies() }
            val upcomingMovies = async { ApiClient.client.create(MoviesService::class.java).getUpcomingMovies() }
            val topRatedMovies = async { ApiClient.client.create(MoviesService::class.java).getTopRatedMovies() }

            nowShowingMovies.await()
            popularMovies.await()
            upcomingMovies.await()
            topRatedMovies.await()

            // hitanshu : how to deal with error?
        }
    }

}