package com.hitanshudhawan.popcorn2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.network.MoviesService

// link : https://developer.android.com/topic/libraries/architecture/coroutines#livedata
// link : https://github.com/InsertKoinIO/koin/issues/7
class MoviesViewModel(private val moviesService: MoviesService) : ViewModel() {

    // hitanshu : handle API errors

    val nowShowingText = MutableLiveData<String>().apply { value = "Now Showing" }
    val nowShowingMovies = liveData {
        emit(moviesService.getNowShowingMovies().results)
    }

    val popularText = MutableLiveData<String>().apply { value = "Popular" }
    val popularMovies = liveData {
        emit(moviesService.getPopularMovies().results)
    }

    val upcomingText = MutableLiveData<String>().apply { value = "Upcoming" }
    val upcomingMovies = liveData {
        emit(moviesService.getUpcomingMovies().results)
    }

    val topRatedText = MutableLiveData<String>().apply { value = "Top Rated" }
    val topRatedMovies = liveData {
        emit(moviesService.getTopRatedMovies().results)
    }

}