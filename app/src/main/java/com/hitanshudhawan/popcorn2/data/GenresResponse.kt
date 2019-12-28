package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenresResponse(
	val genres: List<Genre>
)

@JsonClass(generateAdapter = true)
data class Genre(
	val id: Int,
	val name: String
)