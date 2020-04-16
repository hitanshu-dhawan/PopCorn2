package com.hitanshudhawan.popcorn2

import android.app.Application
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PopCorn2Application : Application() {

    override fun onCreate() {
        super.onCreate()

        // hitanshu : BuildConfig.DEBUG
        Stetho.initializeWithDefaults(this)

        startKoin {
            androidContext(this@PopCorn2Application)
            modules(
                listOf(
                    viewKoinModule,
                    useCasesKoinModule,
                    repositoryKoinModule,
                    databaseKoinModule,
                    networkKoinModule
                )
            )
        }

    }

}
