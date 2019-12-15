package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface MoviesUseCases {

    fun getNowPlayingMovies(): LiveData<Resource<List<ShowBannerData>>>

    fun getPopularMovies(): LiveData<Resource<List<ShowCardData>>>

    //...

}