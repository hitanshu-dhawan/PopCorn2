package com.hitanshudhawan.popcorn2

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosResponse(
    val results: List<Video>
)

@JsonClass(generateAdapter = true)
data class Video(
    val key: String,
    val name: String,
    val site: String,
    val type: String
)