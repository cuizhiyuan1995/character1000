package com.classic.character1000.network

import com.classic.character1000.dictionary.ChineseDict
import com.classic.character1000.dictionary.SimplifiedChinese
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SimplifiedService {
       @GET("convert")
    suspend fun convertText(
        @Query("converter") converter: String,
        @Query("text") text: String,
        @Query("prettify") prettify: Int
    ): Response<SimplifiedChinese>
}