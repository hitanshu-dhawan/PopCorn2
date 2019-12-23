package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.database.cache.GenresDao
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val genresDao: GenresDao
) : GenresRepository {

    override fun getMovieGenres() = resource<List<Genre>>(
        network = {
            val response = safe { genresService.getMovieGenres() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.genres.mapToGenres())
            else
                Resource.Error()
        },
        database = {
            val genreEntities = safe { genresDao.getMovieGenres() }
            if (genreEntities != null && genreEntities.isNotEmpty())
                Resource.Success(genreEntities.mapToGenres())
            else
                Resource.Error()
        },
        save = {
            genresDao.insertMovieGenres(it.mapToMovieGenreEntities())
        }
    )

    override fun getTVShowGenres() = resource<List<Genre>>(
        network = {
            val response = safe { genresService.getTVShowGenres() }
            if (response != null && response.isSuccessful)
                Resource.Success(response.body()!!.genres.mapToGenres())
            else
                Resource.Error()
        },
        database = {
            val genreEntities = safe { genresDao.getTVShowGenres() }
            if (genreEntities != null && genreEntities.isNotEmpty())
                Resource.Success(genreEntities.mapToGenres())
            else
                Resource.Error()
        },
        save = {
            genresDao.insertTVShowGenres(it.mapToTVShowGenreEntities())
        }
    )

}
