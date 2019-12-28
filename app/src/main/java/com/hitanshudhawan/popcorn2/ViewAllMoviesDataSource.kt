package com.hitanshudhawan.popcorn2

import androidx.paging.PageKeyedDataSource
import com.hitanshudhawan.popcorn2.database.cache.CacheMoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewAllMoviesDataSource(
    private val moviesService: MoviesService,
    private val cacheMoviesDao: CacheMoviesDao
    //...
) : PageKeyedDataSource<Int, MovieBrief>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieBrief>) {
        GlobalScope.launch {
            val response = safe { moviesService.getNowPlayingMovies(1) }
            if (response != null && response.isSuccessful) {
                val movieBriefs = response.body()!!.results.mapToMovieBriefs()
                callback.onResult(movieBriefs, null, 2)
                cacheMoviesDao.insertNowPlayingMovies(movieBriefs.mapToNowPlayingMovieBriefEntities())
            } else {
                val movieBriefEntities = safe { cacheMoviesDao.getNowPlayingMovies() } // todo: only 20 entities
                if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                    callback.onResult(movieBriefEntities.mapToMovieBriefs(), null, 2)
                else
                    callback.onError(Exception())
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
        //
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
//        GlobalScope.launch {
//            val response = safe { moviesService.getNowPlayingMovies(params.key) }
//            if (response != null && response.isSuccessful)
//                callback.onResult(response.body()!!.results.mapToMovieBriefs(), params.key + 1)
//            else
//                callback.onError(Exception())
//        }
    }

}
