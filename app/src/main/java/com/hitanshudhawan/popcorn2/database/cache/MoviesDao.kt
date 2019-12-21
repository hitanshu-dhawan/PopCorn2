package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// hitanshu : Can we club all ****MovieBriefEntity classes into one
@Dao
interface MoviesDao {

    @Query("SELECT * FROM NowPlayingMovieBriefEntity")
    suspend fun getNowPlayingMovies(): List<NowPlayingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(movieBriefEntities: List<NowPlayingMovieBriefEntity>)

    @Query("SELECT * FROM PopularMovieBriefEntity")
    suspend fun getPopularMovies(): List<PopularMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movieBriefEntities: List<PopularMovieBriefEntity>)

    @Query("SELECT * FROM UpcomingMovieBriefEntity")
    suspend fun getUpcomingMovies(): List<UpcomingMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpcomingMovies(movieBriefEntities: List<UpcomingMovieBriefEntity>)

    @Query("SELECT * FROM TopRatedMovieBriefEntity")
    suspend fun getTopRatedMovies(): List<TopRatedMovieBriefEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(movieBriefEntities: List<TopRatedMovieBriefEntity>)

}