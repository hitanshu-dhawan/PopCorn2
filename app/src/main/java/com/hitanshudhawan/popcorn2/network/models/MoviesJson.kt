package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesJson(
    val page: Int,
    val results: List<MovieBriefJson>,
    val total_pages: Int,
    val total_results: Int
)

@JsonClass(generateAdapter = true)
data class MovieBriefJson(
    val poster_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val title: String,
    val backdrop_path: String?,
    val vote_average: Double
)