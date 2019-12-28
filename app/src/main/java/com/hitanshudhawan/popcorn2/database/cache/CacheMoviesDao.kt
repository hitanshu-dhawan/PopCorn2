package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CacheMoviesDao {

    @Query("SELECT * FROM CacheNowPlayingMovieBriefEntity WHERE page = :page")
    suspend fun getNowPlayingMovies(page: Int = 1): List<CacheNowPlayingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(movieBriefEntities: List<CacheNowPlayingMovieBriefEntity>)

    @Query("SELECT * FROM CachePopularMovieBriefEntity WHERE page = :page")
    suspend fun getPopularMovies(page: Int = 1): List<CachePopularMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movieBriefEntities: List<CachePopularMovieBriefEntity>)

    @Query("SELECT * FROM CacheUpcomingMovieBriefEntity WHERE page = :page")
    suspend fun getUpcomingMovies(page: Int = 1): List<CacheUpcomingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(movieBriefEntities: List<CacheUpcomingMovieBriefEntity>)

    @Query("SELECT * FROM CacheTopRatedMovieBriefEntity WHERE page = :page")
    suspend fun getTopRatedMovies(page: Int = 1): List<CacheTopRatedMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(movieBriefEntities: List<CacheTopRatedMovieBriefEntity>)

}

// hitanshu : Can we club all ****MovieBriefEntity classes into one
// hitanshu : insert methods should first delete old values : write test cases for it
