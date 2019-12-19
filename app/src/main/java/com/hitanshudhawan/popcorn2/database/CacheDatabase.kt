package com.hitanshudhawan.popcorn2.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MovieGenreEntity::class, TVShowGenreEntity::class], version = 1)
abstract class CacheDatabase : RoomDatabase() {

    abstract fun genresDao(): GenresDao

}