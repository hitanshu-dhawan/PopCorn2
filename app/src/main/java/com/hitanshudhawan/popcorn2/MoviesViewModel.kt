package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

//    private val _nowPlayingMovies = MutableLiveData<List<MovieBriefJson>>()
//    val nowPlayingMovies: LiveData<List<MovieBriefJson>> = _nowPlayingMovies

//    private val _popularMovies = MutableLiveData<List<MovieBriefJson>>()
//    val popularMovies: LiveData<List<MovieBriefJson>> = _popularMovies

//    init {
//        viewModelScope.launch {
//            _nowPlayingMovies.value = moviesRepository.getNowPlayingMovies()
//            _popularMovies.value = moviesRepository.getPopularMovies()
//        }
//    }

    val nowPlayingMovies: LiveData<List<MovieBriefJson>> = moviesRepository.getNowPlayingMovies()

    val popularMovies: LiveData<List<MovieBriefJson>> = moviesRepository.getPopularMovies()

    val upcomingMovies: LiveData<List<MovieBriefJson>> = moviesRepository.getUpcomingMovies()

    val topRatedMovies: LiveData<List<MovieBriefJson>> = moviesRepository.getTopRatedMovies()

}