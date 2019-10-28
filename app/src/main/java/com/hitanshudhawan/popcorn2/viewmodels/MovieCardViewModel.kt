package com.hitanshudhawan.popcorn2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hitanshudhawan.popcorn2.network.models.Movie

// hitanshu : this is probably the wrong way of doing this
class MovieCardViewModel(movie: Movie) : ViewModel() {

    val title = MutableLiveData<String>().apply { value = movie.title }
    val image = MutableLiveData<String>().apply { value = "https://image.tmdb.org/t/p/w780/${movie.backdropPath}" }
    val rating = MutableLiveData<String>().apply { value = String.format("%.1f", movie.voteAverage) + "\u2605" }

}