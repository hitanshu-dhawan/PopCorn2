package com.hitanshudhawan.popcorn2.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoviesResponse(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<Movie>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
)

@JsonClass(generateAdapter = true)
data class Movie(
    @Json(name = "poster_path")
    var posterPath: String?,
    @Json(name = "adult")
    var adult: Boolean,
    @Json(name = "overview")
    var overview: String,
    @Json(name = "release_date")
    var releaseDate: String,
    @Json(name = "genre_ids")
    var genreIds: List<Int>,
    @Json(name = "id")
    var id: Int,
    @Json(name = "original_title")
    var originalTitle: String,
    @Json(name = "original_language")
    var originalLanguage: String,
    @Json(name = "title")
    var title: String,
    @Json(name = "backdrop_path")
    var backdropPath: String?,
    @Json(name = "popularity")
    var popularity: Double,
    @Json(name = "vote_count")
    var voteCount: Int,
    @Json(name = "video")
    var video: Boolean,
    @Json(name = "vote_average")
    var voteAverage: Double
)