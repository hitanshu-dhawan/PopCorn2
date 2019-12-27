package com.hitanshudhawan.popcorn2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class ViewAllMoviesViewModel(
    private val dataSourceFactory: ViewAllMoviesDataSourceFactory,
    private val config: PagedList.Config
) : ViewModel() {

    //todo : getPaginatedMovieBriefs() - change name
    fun getPaginatedMovieBriefs(): LiveData<PagedList<MovieBrief>> {
        return LivePagedListBuilder(dataSourceFactory, config).build()
    }

}
