package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TVShowJsonResponse(
    val backdrop_path: String?,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<GenreJson>,
    val homepage: String,
    val id: Int,
    val name: String,
    val networks: List<NetworkJson>,
    val origin_country: List<String>,
    val overview: String,
    val poster_path: String?,
    val status: String,
    val vote_average: Double
)

@JsonClass(generateAdapter = true)
data class NetworkJson(
    val name: String
)