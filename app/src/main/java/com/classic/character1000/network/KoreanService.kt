package com.classic.character1000.network

import com.classic.character1000.dictionary.EnglishDict
import com.classic.character1000.dictionary.KoreanDict
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface KoreanService {
    @GET("jsonapi")
    suspend fun KoreanMeaning(
        @Query("q") char: String,
        @Query("le") language: String = "ko"
    ): Response<KoreanDict>
}