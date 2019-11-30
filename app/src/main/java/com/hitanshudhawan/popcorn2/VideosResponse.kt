package com.hitanshudhawan.popcorn2

data class VideosResponse(
    val results: List<Video>
)

data class Video(
    val key: String,
    val name: String,
    val site: String
)