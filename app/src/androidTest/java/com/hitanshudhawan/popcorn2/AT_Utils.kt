package com.hitanshudhawan.popcorn2

import androidx.test.InstrumentationRegistry

object AT_Utils {

    fun getJson(path: String): String {
        val context = InstrumentationRegistry.getContext()
        val file = context.assets.open(path)
        return String(file.readBytes())
    }

}