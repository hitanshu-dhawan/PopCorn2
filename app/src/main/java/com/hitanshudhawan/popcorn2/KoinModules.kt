package com.hitanshudhawan.popcorn2

import com.hitanshudhawan.popcorn2.network.MoviesService
import com.hitanshudhawan.popcorn2.viewmodels.MoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    viewModel { MoviesViewModel(get()) }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(MoviesService::class.java) as MoviesService }

}

// link : https://insert-koin.io/docs/2.0/getting-started/kotlin/
// link : https://insert-koin.io/docs/2.0/getting-started/android/
// link : https://insert-koin.io/docs/2.0/getting-started/android-viewmodel/
// link : https://insert-koin.io/docs/2.0/getting-started/junit-test/