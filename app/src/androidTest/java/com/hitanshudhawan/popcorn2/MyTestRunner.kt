package com.hitanshudhawan.popcorn2

import android.app.Application
import android.content.Context
import android.os.StrictMode
import androidx.test.runner.AndroidJUnitRunner

// link : https://github.com/square/okhttp/issues/3184
class MyTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {

        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())

        return super.newApplication(cl, TestApplication::class.java.name, context)
    }

}