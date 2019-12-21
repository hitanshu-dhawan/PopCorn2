package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

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
@TypeConverters(CacheTypeConverters::class)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao

    abstract fun genresDao(): GenresDao

}