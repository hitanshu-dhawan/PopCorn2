package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CachePopularMovieBriefEntity(
    @PrimaryKey
    val orderIndex: Int,
    val id: Int,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val rating: Double,
    val genreIds: List<Int>
)
