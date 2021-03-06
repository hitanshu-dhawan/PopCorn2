package com.hitanshudhawan.popcorn2.koin

import androidx.paging.PagedList
import androidx.room.Room
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.hitanshudhawan.popcorn2.*
import com.hitanshudhawan.popcorn2.database.favorite.FavoriteDatabase
import com.hitanshudhawan.popcorn2.network.ApiKeyInterceptor
import com.hitanshudhawan.popcorn2.network.GenresService
import com.hitanshudhawan.popcorn2.network.MoviesService
import com.hitanshudhawan.popcorn2.network.TVShowsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*

val viewKoinModule = module {

    viewModel { MoviesViewModel(get()) }

}

val useCasesKoinModule = module {

    single<MoviesUseCases> { MoviesUseCasesImpl(get(), get()) }

}

val repositoryKoinModule = module {

    single<MoviesRepository> { MoviesRepositoryImpl(get(), get()) }
    single<GenresRepository> { GenresRepositoryImpl(get()) }

}

val databaseKoinModule = module {

    // Favorites
    single {
        Room.databaseBuilder(
            androidContext(),
            FavoriteDatabase::class.java,
            FavoriteDatabase::class.java.simpleName
        ).build()
    }

    single { get<FavoriteDatabase>().favoriteMoviesDao() }
    single { get<FavoriteDatabase>().favoriteTVShowsDao() }

}

val networkKoinModule = module {

    // OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(BuildConfig.API_KEY))
            // hitanshu : BuildConfig.DEBUG
            .addNetworkInterceptor(StethoInterceptor())
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
            .baseUrl("https://api.themoviedb.org/3/") // todo : use koin properties for base url, it can be changed programmatically in testing (getKoin())
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single { get<Retrofit>().create(MoviesService::class.java) }
    single { get<Retrofit>().create(TVShowsService::class.java) }
    single { get<Retrofit>().create(GenresService::class.java) }

}