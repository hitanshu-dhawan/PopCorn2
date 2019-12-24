package com.hitanshudhawan.popcorn2

// hitanshu : make a base class UIState
sealed class MoviesState {

    class Success(
        val nowPlayingMovies: List<ShowData>,
        val popularMovies: List<ShowData>,
        val upcomingMovies: List<ShowData>,
        val topRatedMovies: List<ShowData>
    ) : MoviesState()

    object Error : MoviesState()

    object Loading : MoviesState()

}
