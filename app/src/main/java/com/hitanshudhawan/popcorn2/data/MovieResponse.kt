package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class MovieResponse(
	val backdrop_path: String?,
	val genres: List<Genre>,
	val homepage: String?,
	val id: Int,
	val imdb_id: String?,
	val overview: String?,
	val poster_path: String?,
	val release_date: Date,
	val runtime: Int?,
	val tagline: String?,
	val title: String,
	val vote_average: Double
)