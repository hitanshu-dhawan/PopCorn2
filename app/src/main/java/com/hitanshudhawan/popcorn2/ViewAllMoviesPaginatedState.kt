package com.hitanshudhawan.popcorn2

// hitanshu : make a base class UIState | or use Resource.kt
sealed class ViewAllMoviesPaginatedState {

    object Success : ViewAllMoviesPaginatedState()

    object Error : ViewAllMoviesPaginatedState()

    object Loading : ViewAllMoviesPaginatedState()

}
