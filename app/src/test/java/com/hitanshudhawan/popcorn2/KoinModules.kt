package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.network.MoviesService
import com.hitanshudhawan.popcorn2.viewmodels.MoviesViewModel
import okhttp3.mockwebserver.MockWebServer
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val testModule = module {

    viewModel { MoviesViewModel(get()) }

    single { MockWebServer() }
    single {
        Retrofit.Builder()
            .baseUrl(get<MockWebServer>().url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(MoviesService::class.java) as MoviesService }

}