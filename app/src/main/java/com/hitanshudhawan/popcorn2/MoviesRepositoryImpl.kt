package com.hitanshudhawan.popcorn2

import androidx.lifecycle.map
import com.hitanshudhawan.popcorn2.database.cache.CacheMoviesDao
import com.hitanshudhawan.popcorn2.database.favorite.FavoriteMovieBriefEntity
import com.hitanshudhawan.popcorn2.database.favorite.FavoriteMoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val moviesService: MoviesService,
    private val cacheMoviesDao: CacheMoviesDao,
    private val favoriteMoviesDao: FavoriteMoviesDao
) : MoviesRepository {

    override suspend fun getNowPlayingMovies(page: Int) = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getNowPlayingMovies(page) }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { cacheMoviesDao.getNowPlayingMovies(page) }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertNowPlayingMovies(it.mapToNowPlayingMovieBriefEntities())
        }
    )

    override suspend fun getPopularMovies(page: Int) = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getPopularMovies(page) }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { cacheMoviesDao.getPopularMovies(page) }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertPopularMovies(it.mapToPopularMovieBriefEntities())
        }
    )

    override suspend fun getUpcomingMovies(page: Int) = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getUpcomingMovies(page) }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { cacheMoviesDao.getUpcomingMovies(page) }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertUpcomingMovies(it.mapToUpcomingMovieBriefEntities())
        }
    )

    override suspend fun getTopRatedMovies(page: Int) = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getTopRatedMovies(page) }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { cacheMoviesDao.getTopRatedMovies(page) }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertTopRatedMovies(it.mapToTopRatedMovieBriefEntities())
        }
    )

    override fun isFavoriteMovie(id: Int) = favoriteMoviesDao.getFavoriteMovieLiveData(id).map { it != null }

    override suspend fun toggleFavoriteMovie(movieBrief: MovieBrief) {
        withContext(Dispatchers.IO) {
            safe { favoriteMoviesDao.toggleFavoriteMovie(FavoriteMovieBriefEntity(0, movieBrief.id, movieBrief.title, movieBrief.poster, movieBrief.backdrop, movieBrief.rating, movieBrief.genreIds)) }
        }
    }

}

// hitanshu : You can use strategy pattern for all 4 types of movies.
