package com.hitanshudhawan.popcorn2

import java.io.File

object AT_Utils {

    fun getJson(path: String): String {
        val uri = this.javaClass.classLoader!!.getResource(path)
        val file = File(uri.path)
        return String(file.readBytes())
    }

}