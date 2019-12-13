package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.network.models.CreditsJsonResponse
import com.hitanshudhawan.popcorn2.network.models.TVShowJsonResponse
import com.hitanshudhawan.popcorn2.network.models.TVShowsJsonResponse
import com.hitanshudhawan.popcorn2.network.models.VideosJsonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsService {

    @GET("tv/airing_today")
    suspend fun getAiringTodayTVShows(@Query("page") page: Int = 1): TVShowsJsonResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTVShows(@Query("page") page: Int = 1): TVShowsJsonResponse

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("page") page: Int = 1): TVShowsJsonResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTVShows(@Query("page") page: Int = 1): TVShowsJsonResponse

    @GET("tv/{tv_id}")
    suspend fun getTVShowDetails(@Path("tv_id") tvShowId: Int): TVShowJsonResponse

    @GET("tv/{tv_id}/videos")
    suspend fun getTVShowVideos(@Path("tv_id") tvShowId: Int): VideosJsonResponse

    @GET("tv/{tv_id}/credits")
    suspend fun getTVShowCredits(@Path("tv_id") tvShowId: Int): CreditsJsonResponse

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTVShows(@Path("tv_id") tvShowId: Int): TVShowsJsonResponse

}