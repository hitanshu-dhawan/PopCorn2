package com.hitanshudhawan.popcorn2

// hitanshu : make a base class UIState | or use Resource.kt
sealed class ViewAllMoviesState {

    object Success : ViewAllMoviesState()

    object Error : ViewAllMoviesState()

    object Loading : ViewAllMoviesState()

}
