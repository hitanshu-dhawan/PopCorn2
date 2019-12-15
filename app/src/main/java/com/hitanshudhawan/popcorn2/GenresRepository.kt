package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData

interface GenresRepository {

    fun getMovieGenres(): LiveData<Resource<List<Genre>>>

}