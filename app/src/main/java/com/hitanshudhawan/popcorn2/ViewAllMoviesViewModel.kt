package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class ViewAllMoviesViewModel(
    private val moviesType: ViewAllMoviesFragment.MoviesType,
    private val dataSourceFactory: ViewAllMoviesDataSourceFactory,
    private val config: PagedList.Config
) : ViewModel() {

    fun getPaginatedMovies(): LiveData<PagedList<MovieBrief>> {
        return LivePagedListBuilder(dataSourceFactory, config).build()
    }

}
