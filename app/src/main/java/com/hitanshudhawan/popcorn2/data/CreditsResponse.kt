package com.hitanshudhawan.popcorn2.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CreditsResponse(
	val cast: List<Cast>
)

@JsonClass(generateAdapter = true)
data class Cast(
	val character: String,
	val id: Int,
	val name: String,
	val profile_path: String?
)