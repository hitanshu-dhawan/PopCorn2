package com.hitanshudhawan.popcorn2.network

import com.hitanshudhawan.popcorn2.data.CreditsResponse
import com.hitanshudhawan.popcorn2.data.TVShowResponse
import com.hitanshudhawan.popcorn2.data.TVShowsResponse
import com.hitanshudhawan.popcorn2.data.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TVShowsService {

    @GET("tv/airing_today")
    suspend fun getAiringTodayTVShows(@Query("page") page: Int = 1): TVShowsResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTVShows(@Query("page") page: Int = 1): TVShowsResponse

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("page") page: Int = 1): TVShowsResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTVShows(@Query("page") page: Int = 1): TVShowsResponse

    @GET("tv/{tv_id}")
    suspend fun getTVShowDetails(@Path("tv_id") tvShowId: Int): TVShowResponse

    @GET("tv/{tv_id}/videos")
    suspend fun getTVShowVideos(@Path("tv_id") tvShowId: Int): VideosResponse

    @GET("tv/{tv_id}/credits")
    suspend fun getTVShowCredits(@Path("tv_id") tvShowId: Int): CreditsResponse

    @GET("tv/{tv_id}/similar")
    suspend fun getSimilarTVShows(@Path("tv_id") tvShowId: Int): TVShowsResponse

}