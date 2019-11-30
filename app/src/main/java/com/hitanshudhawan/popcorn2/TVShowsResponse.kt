package com.hitanshudhawan.popcorn2

data class TVShowsResponse(
    val page: Int,
    val results: List<TVShowBrief>,
    val total_results: Int,
    val total_pages: Int
)

data class TVShowBrief(
    val poster_path: String?,
    val id: Int,
    val backdrop_path: String?,
    val vote_average: Double,
    val genre_ids: List<Int>,
    val name: String
)