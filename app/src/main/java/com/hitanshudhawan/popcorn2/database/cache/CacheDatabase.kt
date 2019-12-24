package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hitanshudhawan.popcorn2.database.RoomTypeConverters

@Database(
    entities = [
        NowPlayingMovieBriefEntity::class,
        PopularMovieBriefEntity::class,
        UpcomingMovieBriefEntity::class,
        TopRatedMovieBriefEntity::class,
        MovieGenreEntity::class,
        TVShowGenreEntity::class
    ],
    version = 1
)
@TypeConverters(RoomTypeConverters::class)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    abstract fun genresDao(): GenresDao

}
