package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.database.cache.MoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService

class MoviesRepositoryImpl(
    private val moviesService: MoviesService,
    private val moviesDao: MoviesDao
) : MoviesRepository {

    override fun getNowPlayingMovies() = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getNowPlayingMovies() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.results.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { moviesDao.getNowPlayingMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            moviesDao.insertNowPlayingMovies(it.mapToNowPlayingMovieBriefEntities())
        }
    )

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
            moviesDao.insertPopularMovies(it.mapToPopularMovieBriefEntities())
        }
    )

    override fun getUpcomingMovies() = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getUpcomingMovies() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.results.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { moviesDao.getUpcomingMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            moviesDao.insertUpcomingMovies(it.mapToUpcomingMovieBriefEntities())
        }
    )

    override fun getTopRatedMovies() = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getTopRatedMovies() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.results.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { moviesDao.getTopRatedMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            moviesDao.insertTopRatedMovies(it.mapToTopRatedMovieBriefEntities())
        }
    )

}
