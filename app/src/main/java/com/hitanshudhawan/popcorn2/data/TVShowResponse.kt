package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShowResponse(
	val backdrop_path: String?,
	val episode_run_time: List<Int>,
	val first_air_date: String,
	val genres: List<Genre>,
	val homepage: String,
	val id: Int,
	val name: String,
	val networks: List<Network>,
	val origin_country: List<String>,
	val overview: String,
	val poster_path: String?,
	val status: String,
	val vote_average: Double
)

@JsonClass(generateAdapter = true)
data class Network(
	val name: String
)