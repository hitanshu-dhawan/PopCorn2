package com.hitanshudhawan.popcorn2

data class MovieBrief(
    val id: Int,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val rating: Double,
    val genres: List<String>
)