package com.hitanshudhawan.popcorn2

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
    val vote_average: Number
)

data class Network(
    val name: String
)