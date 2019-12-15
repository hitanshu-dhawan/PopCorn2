package com.hitanshudhawan.popcorn2

// hitanshu : make a base class UIState
sealed class MoviesState {

    class Success(
        val nowPlayingMovies: List<ShowBannerData>,
        val popularMovies: List<ShowCardData>
    ) : MoviesState()

    object Error : MoviesState()

    object Loading : MoviesState()

}