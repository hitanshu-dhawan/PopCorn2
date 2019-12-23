package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.cache.MoviesDao
import com.hitanshudhawan.popcorn2.database.cache.PopularMovieBriefEntity
import com.hitanshudhawan.popcorn2.network.MoviesService

class MoviesRepositoryImpl(
    private val moviesService: MoviesService,
    private val moviesDao: MoviesDao
) : MoviesRepository {

    override fun getNowPlayingMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = safe { moviesService.getNowPlayingMovies() }
        if (response != null && response.isSuccessful) {
            moviesDao.insertNowPlayingMovies(response.body()!!.results.mapToNowPlayingMovieBriefEntities())
            emit(Resource.Success(response.body()!!.results.mapToMovieBriefs()))
        } else {
            val movieBriefEntities = moviesDao.getNowPlayingMovies()
            if (movieBriefEntities.isNotEmpty()) {
                emit(Resource.Success(movieBriefEntities.mapToMovieBriefs()))
            } else {
                emit(Resource.Error())
            }
        }
    }

    override fun getPopularMovies() = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getPopularMovies() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.results.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { moviesDao.getPopularMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            moviesDao.insertPopularMovies(it.mapIndexed { index, it -> PopularMovieBriefEntity(index, it.id, it.title, it.poster, it.backdrop, it.rating, it.genreIds) })
        }
    )

    override fun getUpcomingMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = safe { moviesService.getUpcomingMovies() }
        if (response != null && response.isSuccessful) {
            moviesDao.insertUpcomingMovies(response.body()!!.results.mapToUpcomingMovieBriefEntities())
            emit(Resource.Success(response.body()!!.results.mapToMovieBriefs()))
        } else {
            val movieBriefEntities = moviesDao.getUpcomingMovies()
            if (movieBriefEntities.isNotEmpty()) {
                emit(Resource.Success(movieBriefEntities.mapToMovieBriefs()))
            } else {
                emit(Resource.Error())
            }
        }
    }

    override fun getTopRatedMovies() = liveData<Resource<List<MovieBrief>>> {
        emit(Resource.Loading())
        val response = safe { moviesService.getTopRatedMovies() }
        if (response != null && response.isSuccessful) {
            moviesDao.insertTopRatedMovies(response.body()!!.results.mapToTopRatedMovieBriefEntities())
            emit(Resource.Success(response.body()!!.results.mapToMovieBriefs()))
        } else {
            val movieBriefEntities = moviesDao.getTopRatedMovies()
            if (movieBriefEntities.isNotEmpty()) {
                emit(Resource.Success(movieBriefEntities.mapToMovieBriefs()))
            } else {
                emit(Resource.Error())
            }
        }
    }

}
