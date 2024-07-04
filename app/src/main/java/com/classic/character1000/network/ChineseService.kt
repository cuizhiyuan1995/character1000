package com.classic.character1000.network

import com.classic.character1000.dictionary.ChineseDict
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ChineseService {
    //base url https://www.moedict.tw/uni/

    @GET("{id}")
    suspend fun getbyCharacter(@Path("id")character: String): Response<ChineseDict>
}