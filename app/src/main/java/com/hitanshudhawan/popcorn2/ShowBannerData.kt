package com.hitanshudhawan.popcorn2

data class ShowBannerData(
    val backdrop: String,
    val title: String,
    val rating: Double,
    val genres: List<String>
)