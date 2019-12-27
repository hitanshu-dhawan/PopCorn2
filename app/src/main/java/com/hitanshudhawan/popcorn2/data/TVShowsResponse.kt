package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShowsResponse(
	val page: Int,
	val results: List<TVShowBrief>,
	val total_results: Int,
	val total_pages: Int
)

@JsonClass(generateAdapter = true)
data class TVShowBrief(
	val poster_path: String?,
	val id: Int,
	val backdrop_path: String?,
	val vote_average: Double,
	val genre_ids: List<Int>,
	val name: String
)