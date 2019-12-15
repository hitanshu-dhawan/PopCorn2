package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

class MoviesViewModel(private val moviesUseCases: MoviesUseCases) : ViewModel() {

    private val _moviesState = MediatorLiveData<MoviesState>()
    val moviesState: LiveData<MoviesState> = _moviesState

    init {
        _moviesState.value = MoviesState.Loading

        val liveData1 = moviesUseCases.getNowPlayingMovies()
        val liveData2 = moviesUseCases.getPopularMovies()

        _moviesState.addSource(liveData1) {
            _moviesState.value = someFunction(liveData1, liveData2) //todo
        }
        _moviesState.addSource(liveData2) {
            _moviesState.value = someFunction(liveData1, liveData2) //todo
        }
    }

    private fun someFunction(liveData1: LiveData<Resource<List<ShowBannerData>>>, liveData2: LiveData<Resource<List<ShowCardData>>>): MoviesState {
        val data1 = liveData1.value
        val data2 = liveData2.value
        if (data1 != null && data2 != null) {
            if (data1 is Resource.Success && data2 is Resource.Success) {
                return MoviesState.Success(data1.data, data2.data) //todo
            }
            if (data1 is Resource.Error || data2 is Resource.Error) {
                return MoviesState.Error
            }
        }
        return MoviesState.Loading
    }

}