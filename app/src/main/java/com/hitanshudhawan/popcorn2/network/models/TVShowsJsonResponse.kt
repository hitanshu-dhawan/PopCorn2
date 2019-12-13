package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShowsJsonResponse(
    val page: Int,
    val results: List<TVShowBriefJson>,
    val total_results: Int,
    val total_pages: Int
)

@JsonClass(generateAdapter = true)
data class TVShowBriefJson(
    val poster_path: String?,
    val id: Int,
    val backdrop_path: String?,
    val vote_average: Double,
    val genre_ids: List<Int>,
    val name: String
)