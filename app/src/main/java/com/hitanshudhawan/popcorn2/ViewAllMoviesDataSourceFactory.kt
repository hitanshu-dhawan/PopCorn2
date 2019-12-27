package com.hitanshudhawan.popcorn2

import androidx.paging.DataSource

class ViewAllMoviesDataSourceFactory(private val viewAllMoviesDataSource: ViewAllMoviesDataSource) : DataSource.Factory<Int, MovieBrief>() {

    override fun create(): DataSource<Int, MovieBrief> = viewAllMoviesDataSource

}
