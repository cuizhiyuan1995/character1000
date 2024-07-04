package com.classic.character1000.network

import com.classic.character1000.dictionary.EnglishDict
import com.classic.character1000.dictionary.SimplifiedChinese
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EnglishService {
    @GET("jsonapi")
    suspend fun EnglishMeaning(
        @Query("q") char: String,
        @Query("dicts") dicts: String = "{\"count\":99,\"dicts\":[[\"wuguanghua\"]]}"
    ): Response<EnglishDict>
}