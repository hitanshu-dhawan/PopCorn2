package com.hitanshudhawan.popcorn2

import androidx.lifecycle.ViewModel

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

    val nowPlayingMovies = moviesRepository.getNowPlayingMovies()

    val popularMovies = moviesRepository.getPopularMovies()

    val upcomingMovies = moviesRepository.getUpcomingMovies()

    val topRatedMovies = moviesRepository.getTopRatedMovies()

}