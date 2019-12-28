package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CacheMovieGenreEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)
