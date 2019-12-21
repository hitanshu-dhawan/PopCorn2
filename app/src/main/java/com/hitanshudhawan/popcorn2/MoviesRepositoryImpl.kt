package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.cache.MoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService

class MoviesRepositoryImpl(
    private val moviesService: MoviesService,
    private val moviesDao: MoviesDao
) : MoviesRepository {

    override fun getNowPlayingMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = moviesService.getNowPlayingMovies()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }))
        } else {
            emit(Resource.Error())
        }
    }

    override fun getPopularMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = moviesService.getPopularMovies()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }))
        } else {
            emit(Resource.Error())
        }
    }

    override fun getUpcomingMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = moviesService.getUpcomingMovies()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }))
        } else {
            emit(Resource.Error())
        }
    }

    override fun getTopRatedMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = moviesService.getTopRatedMovies()
        if (response.isSuccessful) {
            emit(Resource.Success(response.body()!!.results.map { MovieBrief(it.id, it.title, it.poster_path, it.backdrop_path, it.vote_average, it.genre_ids) }))
        } else {
            emit(Resource.Error())
        }
    }

}