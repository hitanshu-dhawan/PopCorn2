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

    override fun getNowPlayingMovies() = resource<List<MovieBrief>>(
        network = {
            val response = safe { moviesService.getNowPlayingMovies() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.results.mapToMovieBriefs())
            else
                Resource.Error()
        },
        database = {
            val movieBriefEntities = safe { cacheMoviesDao.getNowPlayingMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertNowPlayingMovies(it.mapToNowPlayingMovieBriefEntities())
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
            val movieBriefEntities = safe { cacheMoviesDao.getPopularMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertPopularMovies(it.mapToPopularMovieBriefEntities())
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
            val movieBriefEntities = safe { cacheMoviesDao.getUpcomingMovies() }
            if (movieBriefEntities != null && movieBriefEntities.isNotEmpty())
                Resource.Success(movieBriefEntities.mapToMovieBriefs())
            else
                Resource.Error()
        },
        save = {
            cacheMoviesDao.insertUpcomingMovies(it.mapToUpcomingMovieBriefEntities())
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
            val movieBriefEntities = safe { cacheMoviesDao.getTopRatedMovies() }
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
