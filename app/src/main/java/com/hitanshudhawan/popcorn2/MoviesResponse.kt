package com.hitanshudhawan.popcorn2

data class MoviesResponse(
    val page: Int,
    val results: List<MovieBrief>,
    val total_pages: Int,
    val total_results: Int
)

data class MovieBrief(
    val poster_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val title: String,
    val backdrop_path: String?,
    val vote_average: Double
)