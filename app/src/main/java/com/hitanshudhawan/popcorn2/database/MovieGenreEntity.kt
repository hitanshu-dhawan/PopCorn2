package com.hitanshudhawan.popcorn2.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieGenreEntity(
    @PrimaryKey
    val id: Int,
    val name: String
)

