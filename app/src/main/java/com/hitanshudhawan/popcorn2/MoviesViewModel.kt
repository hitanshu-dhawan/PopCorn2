package com.hitanshudhawan.popcorn2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel(private val moviesUseCases: MoviesUseCases) : ViewModel() {

    //todo : how to handle swipe to refresh
    //todo : how will you reassign `val moviesState`
    val moviesState by lazy {
        zip(
            moviesUseCases.getNowPlayingMovies(),
            moviesUseCases.getPopularMovies(),
            moviesUseCases.getUpcomingMovies(),
            moviesUseCases.getTopRatedMovies()
        ) { nowPlayingMovieBriefs, popularMovieBriefs, upcomingMovieBriefs, topRatedMovieBriefs ->
            getMoviesState(nowPlayingMovieBriefs, popularMovieBriefs, upcomingMovieBriefs, topRatedMovieBriefs)
        }
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

    fun isFavoriteMovie(id: Int) = moviesUseCases.isFavoriteMovie(id)

    fun toggleFavoriteMovie(showData: ShowData) {
        viewModelScope.launch { moviesUseCases.toggleFavoriteMovie(showData) }
    }

}
