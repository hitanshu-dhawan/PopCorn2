package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
	val page: Int,
	val results: List<MovieBrief>,
	val total_pages: Int,
	val total_results: Int
)

@JsonClass(generateAdapter = true)
data class MovieBrief(
	val poster_path: String?,
	val genre_ids: List<Int>,
	val id: Int,
	val title: String,
	val backdrop_path: String?,
	val vote_average: Double
)