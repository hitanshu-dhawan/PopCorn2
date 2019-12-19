package com.hitanshudhawan.popcorn2.database

import androidx.room.Dao
import androidx.room.Query

@Dao
interface GenresDao {

    @Query("SELECT * FROM MovieGenreEntity")
    suspend fun getMovieGenres(): List<MovieGenreEntity>

    @Query("SELECT * FROM TVShowGenreEntity")
    suspend fun getTVShowGenres(): List<TVShowGenreEntity>

}