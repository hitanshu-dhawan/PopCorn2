package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hitanshudhawan.popcorn2.database.RoomTypeConverters

@Database(
    entities = [
        CacheNowPlayingMovieBriefEntity::class,
        CachePopularMovieBriefEntity::class,
        CacheUpcomingMovieBriefEntity::class,
        CacheTopRatedMovieBriefEntity::class,
        CacheMovieGenreEntity::class,
        CacheTVShowGenreEntity::class
    ],
    version = 1
)
@TypeConverters(RoomTypeConverters::class)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun moviesDao(): CacheMoviesDao

    abstract fun genresDao(): CacheGenresDao

}

// hitanshu : always items are inserted into the DB, which create a LOT of entries in the DB, look into it.
