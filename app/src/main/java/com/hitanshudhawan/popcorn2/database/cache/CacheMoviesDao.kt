package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheMoviesDao {

    @Query("SELECT * FROM CacheNowPlayingMovieBriefEntity")
    suspend fun getNowPlayingMovies(): List<CacheNowPlayingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(movieBriefEntities: List<CacheNowPlayingMovieBriefEntity>)

    @Query("SELECT * FROM CachePopularMovieBriefEntity")
    suspend fun getPopularMovies(): List<CachePopularMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movieBriefEntities: List<CachePopularMovieBriefEntity>)

    @Query("SELECT * FROM CacheUpcomingMovieBriefEntity")
    suspend fun getUpcomingMovies(): List<CacheUpcomingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(movieBriefEntities: List<CacheUpcomingMovieBriefEntity>)

    @Query("SELECT * FROM CacheTopRatedMovieBriefEntity")
    suspend fun getTopRatedMovies(): List<CacheTopRatedMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(movieBriefEntities: List<CacheTopRatedMovieBriefEntity>)

}

// hitanshu : Can we club all ****MovieBriefEntity classes into one
// hitanshu : insert methods should first delete old values : write test cases for it
