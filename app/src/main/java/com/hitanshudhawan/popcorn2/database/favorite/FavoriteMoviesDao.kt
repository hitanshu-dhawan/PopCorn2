package com.hitanshudhawan.popcorn2.database.favorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteMoviesDao {

    interface FavoriteMoviesDao {

        @Query("SELECT * FROM FavoriteMovieBriefEntity WHERE id = :id")
        fun getFavoriteMovie(id: Int): LiveData<FavoriteMovieBriefEntity>

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertFavoriteMovie(movieBriefEntity: FavoriteMovieBriefEntity)

    }

}
