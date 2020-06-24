package com.hitanshudhawan.popcorn2

import androidx.lifecycle.map
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val moviesService: MoviesService
) : MoviesRepository {

    override suspend fun getNowPlayingMovies(page: Int): Resource<List<MovieBrief>> {
        val response = safe { moviesService.getNowPlayingMovies(page) }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToMovieBriefs())
        else
            return Resource.Error()
    }

    override suspend fun getPopularMovies(page: Int): Resource<List<MovieBrief>> {
        val response = safe { moviesService.getPopularMovies(page) }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToMovieBriefs())
        else
            return Resource.Error()
    }

    override suspend fun getUpcomingMovies(page: Int): Resource<List<MovieBrief>> {
        val response = safe { moviesService.getUpcomingMovies(page) }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToMovieBriefs())
        else
            return Resource.Error()
    }

    override suspend fun getTopRatedMovies(page: Int): Resource<List<MovieBrief>> {
        val response = safe { moviesService.getTopRatedMovies(page) }
        if (response != null && response.isSuccessful)
            return Resource.Success(response.body()!!.mapToMovieBriefs())
        else
            return Resource.Error()
    }

}

// hitanshu : You can use strategy pattern for all 4 types of movies.