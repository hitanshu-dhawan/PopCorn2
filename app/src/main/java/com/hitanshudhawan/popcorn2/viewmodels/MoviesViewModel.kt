package com.hitanshudhawan.popcorn2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.network.ApiClient
import com.hitanshudhawan.popcorn2.network.MoviesService

class MoviesViewModel : ViewModel() {

    val nowShowingText = MutableLiveData<String>().apply { value = "Now Showing" }
    val nowShowingMovies = liveData {
        emit(ApiClient.client.create(MoviesService::class.java).getNowShowingMovies().results)
    }

    val popularText = MutableLiveData<String>().apply { value = "Popular" }
    val popularMovies = liveData {
        emit(ApiClient.client.create(MoviesService::class.java).getPopularMovies().results)
    }

    val upcomingText = MutableLiveData<String>().apply { value = "Upcoming" }
    val upcomingMovies = liveData {
        emit(ApiClient.client.create(MoviesService::class.java).getUpcomingMovies().results)
    }

    val topRatedText = MutableLiveData<String>().apply { value = "Top Rated" }
    val topRatedMovies = liveData {
        emit(ApiClient.client.create(MoviesService::class.java).getTopRatedMovies().results)
    }

}