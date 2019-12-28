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

// hitanshu : 29th December 2019 : todo - for ViewAllMovies
// 1. Have initial state and paginated state as LiveData
// 2. Add favorites feature
// 3. Look into solution for multiple (4) types of data sources for pagination
