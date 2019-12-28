package com.hitanshudhawan.popcorn2

import androidx.lifecycle.liveData
import com.hitanshudhawan.popcorn2.database.cache.CacheGenresDao
import com.hitanshudhawan.popcorn2.network.GenresService

class GenresRepositoryImpl(
    private val genresService: GenresService,
    private val cacheGenresDao: CacheGenresDao
) : GenresRepository {

    override fun getMovieGenres() = liveData {
        emit(Resource.Loading())
        emit(
            resource<List<Genre>>(
                network = {
                    val response = safe { genresService.getMovieGenres() }
                    if (response != null && response.isSuccessful)
                        Resource.Success(response.body()!!.mapToGenres())
                    else
                        Resource.Error()
                },
                database = {
                    val genreEntities = safe { cacheGenresDao.getMovieGenres() }
                    if (genreEntities != null && genreEntities.isNotEmpty())
                        Resource.Success(genreEntities.mapToGenres())
                    else
                        Resource.Error()
                },
                save = {
                    cacheGenresDao.insertMovieGenres(it.mapToMovieGenreEntities())
                }
            )
        )
    }

    override fun getTVShowGenres() = liveData {
        emit(Resource.Loading())
        emit(
            resource<List<Genre>>(
                network = {
                    val response = safe { genresService.getTVShowGenres() }
                    if (response != null && response.isSuccessful)
                        Resource.Success(response.body()!!.mapToGenres())
                    else
                        Resource.Error()
                },
                database = {
                    val genreEntities = safe { cacheGenresDao.getTVShowGenres() }
                    if (genreEntities != null && genreEntities.isNotEmpty())
                        Resource.Success(genreEntities.mapToGenres())
                    else
                        Resource.Error()
                },
                save = {
                    cacheGenresDao.insertTVShowGenres(it.mapToTVShowGenreEntities())
                }
            )
        )
    }

}
