package com.classic.character1000.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class LoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url().toString()
        Log.e("Inceptor",url)
        return chain.proceed(request)
    }
}