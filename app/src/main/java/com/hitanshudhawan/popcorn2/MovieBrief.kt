package com.hitanshudhawan.popcorn2

data class MovieBrief(
    val id: Int,
    val title: String,
    val poster: String?,
    val backdrop: String?,
    val rating: Double,
    val genreIds: List<Int>
)