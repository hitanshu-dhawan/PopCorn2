package com.hitanshudhawan.popcorn2.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hitanshudhawan.popcorn2.network.ApiClient
import com.hitanshudhawan.popcorn2.network.MoviesService
import com.hitanshudhawan.popcorn2.network.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel : ViewModel() {

    val nowShowingText = MutableLiveData<String>().apply { value = "Now Showing" }
    private val _nowShowingMovies = MutableLiveData<List<Movie>>()
    val nowShowingMovies: LiveData<List<Movie>>
        get() = _nowShowingMovies

    val popularText = MutableLiveData<String>().apply { value = "Popular" }
    private val _popularMovies = MutableLiveData<List<Movie>>()
    val popularMovies: LiveData<List<Movie>>
        get() = _popularMovies

    val upcomingText = MutableLiveData<String>().apply { value = "Upcoming" }
    private val _upcomingMovies = MutableLiveData<List<Movie>>()
    val upcomingMovies: LiveData<List<Movie>>
        get() = _upcomingMovies

    val topRatedText = MutableLiveData<String>().apply { value = "Top Rated" }
    private val _topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedMovies: LiveData<List<Movie>>
        get() = _topRatedMovies

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            val nowShowingMovies = async { ApiClient.client.create(MoviesService::class.java).getNowShowingMovies() }
            val popularMovies = async { ApiClient.client.create(MoviesService::class.java).getPopularMovies() }
            val upcomingMovies = async { ApiClient.client.create(MoviesService::class.java).getUpcomingMovies() }
            val topRatedMovies = async { ApiClient.client.create(MoviesService::class.java).getTopRatedMovies() }

            withContext(Dispatchers.Main) {
                _nowShowingMovies.value = nowShowingMovies.await().results
                _popularMovies.value = popularMovies.await().results
                _upcomingMovies.value = upcomingMovies.await().results
                _topRatedMovies.value = topRatedMovies.await().results
            }

            // hitanshu : deal with error
        }
    }

}