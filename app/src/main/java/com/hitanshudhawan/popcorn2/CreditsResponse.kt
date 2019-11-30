package com.hitanshudhawan.popcorn2

data class CreditsResponse(
    val cast: List<Cast>
)

data class Cast(
    val character: String,
    val id: Int,
    val name: String,
    val profile_path: String?
)