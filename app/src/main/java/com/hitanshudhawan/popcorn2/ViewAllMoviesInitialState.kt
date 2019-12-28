package com.hitanshudhawan.popcorn2

// hitanshu : make a base class UIState | or use Resource.kt
sealed class ViewAllMoviesInitialState {

    object Success : ViewAllMoviesInitialState()

    object Error : ViewAllMoviesInitialState()

    object Loading : ViewAllMoviesInitialState()

}
