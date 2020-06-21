package com.hitanshudhawan.popcorn2.database.favorite

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hitanshudhawan.popcorn2.database.RoomTypeConverters

@Database(
    entities = [
        FavoriteMovieBriefEntity::class,
        FavoriteTVShowBriefEntity::class
    ],
    version = 1
)
@TypeConverters(RoomTypeConverters::class)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

    abstract fun favoriteTVShowsDao(): FavoriteTVShowsDao

}
