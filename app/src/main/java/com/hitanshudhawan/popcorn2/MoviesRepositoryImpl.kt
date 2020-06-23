package com.hitanshudhawan.popcorn2

import androidx.lifecycle.map
import com.hitanshudhawan.popcorn2.database.favorite.FavoriteMovieBriefEntity
import com.hitanshudhawan.popcorn2.database.favorite.FavoriteMoviesDao
import com.hitanshudhawan.popcorn2.network.MoviesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRepositoryImpl(
    private val moviesService: MoviesService,
    private val favoriteMoviesDao: FavoriteMoviesDao
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

    override fun isFavoriteMovie(id: Int) = favoriteMoviesDao.getFavoriteMovieLiveData(id).map { it != null }

    override suspend fun toggleFavoriteMovie(movieBrief: MovieBrief) {
        withContext(Dispatchers.IO) {
            safe { favoriteMoviesDao.toggleFavoriteMovie(FavoriteMovieBriefEntity(0, movieBrief.id, movieBrief.title, movieBrief.poster, movieBrief.backdrop, movieBrief.rating, movieBrief.genreIds)) }
        }
    }

}

// hitanshu : You can use strategy pattern for all 4 types of movies.