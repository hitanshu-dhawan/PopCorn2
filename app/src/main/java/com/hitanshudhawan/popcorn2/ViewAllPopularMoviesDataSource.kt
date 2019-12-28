package com.hitanshudhawan.popcorn2

import androidx.paging.PageKeyedDataSource
import com.hitanshudhawan.popcorn2.database.cache.CacheMoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ViewAllPopularMoviesDataSource(
    private val moviesService: MoviesService,
    private val cacheMoviesDao: CacheMoviesDao
    //...
) : PageKeyedDataSource<Int, MovieBrief>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, MovieBrief>) {
        GlobalScope.launch {
            val resource = resource<List<MovieBrief>>(
                network = {
                    val response = safe { moviesService.getPopularMovies(1) }
                    if (response != null && response.isSuccessful)
                        Resource.Success(response.body()!!.mapToMovieBriefs())
                    else
                        Resource.Error()
                },
                database = {
                    val movieBriefEntities = safe { cacheMoviesDao.getPopularMovies(1) }
                    if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                        Resource.Success(movieBriefEntities.mapToMovieBriefs())
                    else
                        Resource.Error()
                },
                save = {
                    cacheMoviesDao.insertPopularMovies(it.mapToPopularMovieBriefEntities())
                }
            )

            if (resource is Resource.Success) {
                callback.onResult(resource.data, null, 2)
            } else {
                callback.onError(Exception())
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
        //
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, MovieBrief>) {
        GlobalScope.launch {
            val resource = resource<List<MovieBrief>>(
                network = {
                    val response = safe { moviesService.getPopularMovies(params.key) }
                    if (response != null && response.isSuccessful)
                        Resource.Success(response.body()!!.mapToMovieBriefs())
                    else
                        Resource.Error()
                },
                database = {
                    val movieBriefEntities = safe { cacheMoviesDao.getPopularMovies(params.key) }
                    if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                        Resource.Success(movieBriefEntities.mapToMovieBriefs())
                    else
                        Resource.Error()
                },
                save = {
                    cacheMoviesDao.insertPopularMovies(it.mapToPopularMovieBriefEntities())
                }
            )

            if (resource is Resource.Success) {
                callback.onResult(resource.data, params.key + 1)
            } else {
                callback.onError(Exception())
            }
        }
    }

}
