package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.network.models.CreditsJson
import com.hitanshudhawan.popcorn2.network.models.TVShowJson
import com.hitanshudhawan.popcorn2.network.models.TVShowsJson
import com.hitanshudhawan.popcorn2.network.models.VideosJson
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsService {

    @GET("tv/airing_today")
    suspend fun getAiringTodayTVShows(@Query("page") page: Int = 1): Response<TVShowsJson>

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTVShows(@Query("page") page: Int = 1): Response<TVShowsJson>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("page") page: Int = 1): Response<TVShowsJson>

    @GET("tv/top_rated")
    suspend fun getTopRatedTVShows(@Query("page") page: Int = 1): Response<TVShowsJson>

    @GET("tv/{tv_id}")
    suspend fun getTVShowDetails(@Path("tv_id") tvShowId: Int): Response<TVShowJson>

    @GET("tv/{tv_id}/videos")
    suspend fun getTVShowVideos(@Path("tv_id") tvShowId: Int): Response<VideosJson>

    @GET("tv/{tv_id}/credits")
    suspend fun getTVShowCredits(@Path("tv_id") tvShowId: Int): Response<CreditsJson>

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTVShows(@Path("tv_id") tvShowId: Int): Response<TVShowsJson>

}