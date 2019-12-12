package com.hitanshudhawan.popcorn2

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosJsonResponse(
    val results: List<VideoJson>
)

@JsonClass(generateAdapter = true)
data class VideoJson(
    val key: String,
    val name: String,
    val site: String,
    val type: String
)