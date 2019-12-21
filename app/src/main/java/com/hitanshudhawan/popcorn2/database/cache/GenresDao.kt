package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenresDao {

    @Query("SELECT * FROM MovieGenreEntity")
    suspend fun getMovieGenres(): List<MovieGenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieGenres(genreEntities: List<MovieGenreEntity>)

    @Query("SELECT * FROM TVShowGenreEntity")
    suspend fun getTVShowGenres(): List<TVShowGenreEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTVShowGenres(genreEntities: List<TVShowGenreEntity>)

}

// hitanshu : insert methods should first delete old values : write test cases for it