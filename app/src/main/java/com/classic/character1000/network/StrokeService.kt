package com.classic.character1000.network

import com.classic.character1000.dictionary.StrokeOrder
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StrokeService {
    @GET("{id}.json")
    suspend fun getbyCharacter(@Path("id")character: String): Response<StrokeOrder>
}