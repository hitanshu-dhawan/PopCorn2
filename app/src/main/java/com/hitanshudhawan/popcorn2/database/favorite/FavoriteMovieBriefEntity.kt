package com.hitanshudhawan.popcorn2.database.favorite

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteMovieBriefEntity(
    @PrimaryKey(autoGenerate = true)
    val __id: Int,
    val id: Int,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val rating: Double,
    val genreIds: List<Int>
)
