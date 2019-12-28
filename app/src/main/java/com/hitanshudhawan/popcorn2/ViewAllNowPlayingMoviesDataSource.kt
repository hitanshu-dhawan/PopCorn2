package com.hitanshudhawan.popcorn2

import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewAllNowPlayingMoviesDataSource(
    private val moviesRepository: MoviesRepository
    //...
) : PageKeyedDataSource<Int, MovieBrief>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieBrief>) {
        GlobalScope.launch {
            val movieBriefs = moviesRepository.getNowPlayingMovies(1)

            if (movieBriefs is Resource.Success)
                callback.onResult(movieBriefs.data, null, 2)
            else
                callback.onError(Exception())
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
        //
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
        GlobalScope.launch {
            val movieBriefs = moviesRepository.getNowPlayingMovies(params.key)

            if (movieBriefs is Resource.Success)
                callback.onResult(movieBriefs.data, params.key + 1)
            else
                callback.onError(Exception())
        }
    }

}
