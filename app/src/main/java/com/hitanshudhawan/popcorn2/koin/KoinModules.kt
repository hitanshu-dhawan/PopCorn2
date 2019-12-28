package com.hitanshudhawan.popcorn2.koin

import com.hitanshudhawan.popcorn2.BuildConfig
import com.hitanshudhawan.popcorn2.helpers.ApiKeyInterceptor
import com.hitanshudhawan.popcorn2.network.GenresService
import com.hitanshudhawan.popcorn2.network.MoviesService
import com.hitanshudhawan.popcorn2.network.TVShowsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


val networkKoinModule = module {

    // OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(
                ApiKeyInterceptor(
                    BuildConfig.API_KEY
                )
            )
            .build()
    }

    // Moshi
    single {
        Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter())
            .build()
    }

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single { get<Retrofit>().create(MoviesService::class.java) }
    single { get<Retrofit>().create(TVShowsService::class.java) }
    single { get<Retrofit>().create(GenresService::class.java) }

}