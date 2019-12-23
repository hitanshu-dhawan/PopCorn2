package com.hitanshudhawan.popcorn2.database.favorite

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        FavoriteMovieBriefEntity::class,
        FavoriteTVShowBriefEntity::class
    ],
    version = 1
)
abstract class FavoriteDatabase : RoomDatabase() {

    abstract fun favoriteMoviesDao(): FavoriteMoviesDao

    abstract fun favoriteTVShowsDao(): FavoriteTVShowsDao

}
