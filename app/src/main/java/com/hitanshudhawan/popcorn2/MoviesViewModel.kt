package com.hitanshudhawan.popcorn2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesUseCases: MoviesUseCases) : ViewModel() {

    //todo : how to handle swipe to refresh
    //todo : how will you reassign `val moviesState`
    // hitanshu : use async {} here
    val moviesState = liveData {
        emit(MoviesState.Loading)
        emit(
            getMoviesState(
                moviesUseCases.getNowPlayingMovies(),
                moviesUseCases.getPopularMovies(),
                moviesUseCases.getUpcomingMovies(),
                moviesUseCases.getTopRatedMovies()
            )
        )
    }

    private fun getMoviesState(
        nowPlayingMovieBriefs: Resource<List<ShowData>>,
        popularMovieBriefs: Resource<List<ShowData>>,
        upcomingMovieBriefs: Resource<List<ShowData>>,
        topRatedMovieBriefs: Resource<List<ShowData>>
    ): MoviesState {
        if (nowPlayingMovieBriefs is Resource.Success && popularMovieBriefs is Resource.Success && upcomingMovieBriefs is Resource.Success && topRatedMovieBriefs is Resource.Success)
            return MoviesState.Success(nowPlayingMovieBriefs.data, popularMovieBriefs.data, upcomingMovieBriefs.data, topRatedMovieBriefs.data)
        if (nowPlayingMovieBriefs is Resource.Error || popularMovieBriefs is Resource.Error || upcomingMovieBriefs is Resource.Error || topRatedMovieBriefs is Resource.Error)
            return MoviesState.Error
        return MoviesState.Loading
    }

}
