package com.hitanshudhawan.popcorn2

data class MovieBrief(
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
