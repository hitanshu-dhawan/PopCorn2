package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideosJson(
    val results: List<VideoJson>
)

@JsonClass(generateAdapter = true)
data class VideoJson(
    val key: String,
    val name: String,
    val site: String,
    val type: String
)