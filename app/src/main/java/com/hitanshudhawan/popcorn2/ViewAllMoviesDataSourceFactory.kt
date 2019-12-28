package com.hitanshudhawan.popcorn2

import androidx.paging.DataSource

class ViewAllMoviesDataSourceFactory(
    private val moviesType: ViewAllMoviesFragment.MoviesType,
    private val viewAllNowPlayingMoviesDataSource: ViewAllNowPlayingMoviesDataSource,
    private val viewAllPopularMoviesDataSource: ViewAllPopularMoviesDataSource
) : DataSource.Factory<Int, MovieBrief>() {

    override fun create() = when (moviesType) {
        ViewAllMoviesFragment.MoviesType.NOW_PLAYING -> viewAllNowPlayingMoviesDataSource
        ViewAllMoviesFragment.MoviesType.POPULAR -> viewAllPopularMoviesDataSource
        ViewAllMoviesFragment.MoviesType.UPCOMING -> TODO()
        ViewAllMoviesFragment.MoviesType.TOP_RATED -> TODO()
    }

}
