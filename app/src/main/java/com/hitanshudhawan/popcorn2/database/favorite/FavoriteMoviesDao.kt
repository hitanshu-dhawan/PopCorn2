package com.hitanshudhawan.popcorn2.database.favorite

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
abstract class FavoriteMoviesDao {

    @Query("SELECT * FROM FavoriteMovieBriefEntity WHERE id = :id")
    abstract fun getFavoriteMovieLiveData(id: Int): LiveData<FavoriteMovieBriefEntity?>

    @Query("SELECT * FROM FavoriteMovieBriefEntity WHERE id = :id")
    abstract suspend fun getFavoriteMovie(id: Int): FavoriteMovieBriefEntity?

    @Insert
    abstract suspend fun insertFavoriteMovie(movieBriefEntity: FavoriteMovieBriefEntity)

    @Query("DELETE FROM FavoriteMovieBriefEntity WHERE id = :id")
    abstract suspend fun deleteFavoriteMovie(id: Int)

    @Transaction
    open suspend fun toggleFavoriteMovie(movieBriefEntity: FavoriteMovieBriefEntity) {
        val id = movieBriefEntity.id
        if (getFavoriteMovie(id) == null) {
            insertFavoriteMovie(movieBriefEntity)
        } else {
            deleteFavoriteMovie(id)
        }
    }

}
