package com.hitanshudhawan.popcorn2

import android.app.Application
import com.hitanshudhawan.popcorn2.koin.networkKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PopCorn2Application : Application() {

	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(this@PopCorn2Application)
			modules(
				listOf(
					networkKoinModule
				)
			)
		}
	}
}