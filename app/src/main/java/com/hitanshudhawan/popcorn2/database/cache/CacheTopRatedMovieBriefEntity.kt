package com.hitanshudhawan.popcorn2.database.cache

import androidx.room.Entity

@Entity(primaryKeys = ["page", "index"])
data class CacheTopRatedMovieBriefEntity(
    val page: Int,
    val index: Int,
    //
    val id: Int,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val rating: Double,
    val genreIds: List<Int>
)
