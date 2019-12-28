package com.hitanshudhawan.popcorn2.helpers

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()

        val newRequest = originalRequest.newBuilder()
            .url(
                originalUrl.newBuilder()
                    .addQueryParameter("api_key", apiKey)
                    .build()
            )
            .build()

        return chain.proceed(newRequest)
    }

}