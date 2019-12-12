package com.hitanshudhawan.popcorn2

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenresJsonResponse(
    val genres: List<GenreJson>
)

@JsonClass(generateAdapter = true)
data class GenreJson(
    val id: Int,
    val name: String
)