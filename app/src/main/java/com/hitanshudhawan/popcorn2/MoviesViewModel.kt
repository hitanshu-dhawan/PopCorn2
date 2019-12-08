package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val _nowPlayingMovies = MutableLiveData<List<MovieBrief>>()
    val nowPlayingMovies: LiveData<List<MovieBrief>> = _nowPlayingMovies

    private val _popularMovies = MutableLiveData<List<MovieBrief>>()
    val popularMovies: LiveData<List<MovieBrief>> = _popularMovies

    init {
        viewModelScope.launch {
            _nowPlayingMovies.value = moviesRepository.getNowPlayingMovies()
            _popularMovies.value = moviesRepository.getPopularMovies()
        }
    }

}