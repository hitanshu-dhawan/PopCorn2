package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditsJsonResponse(
    val cast: List<CastJson>
)

@JsonClass(generateAdapter = true)
data class CastJson(
    val character: String,
    val id: Int,
    val name: String,
    val profile_path: String?
)