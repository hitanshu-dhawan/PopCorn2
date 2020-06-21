package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheGenresDao {

    @Query("SELECT * FROM CacheMovieGenreEntity")
    suspend fun getMovieGenres(): List<CacheMovieGenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieGenres(genreEntities: List<CacheMovieGenreEntity>)

    @Query("SELECT * FROM CacheTVShowGenreEntity")
    suspend fun getTVShowGenres(): List<CacheTVShowGenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShowGenres(genreEntities: List<CacheTVShowGenreEntity>)

}

// hitanshu : insert methods should first delete old values : write test cases for it
