package com.hitanshudhawan.popcorn2

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()

        val newRequest = originalRequest.newBuilder()
            .url(
                originalUrl.newBuilder()
                    .addQueryParameter("api_key", "460c0511e1ef5e2eca8734c04a5fb842")
                    .build()
            )
            .build()

        return chain.proceed(newRequest)
    }

}