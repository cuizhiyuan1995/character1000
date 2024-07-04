package com.classic.character1000.network

import com.classic.character1000.dictionary.ChineseDict
import com.classic.character1000.dictionary.EnglishDict
import com.classic.character1000.dictionary.KoreanDict
import com.classic.character1000.dictionary.SimplifiedChinese
import com.classic.character1000.dictionary.StrokeOrder
import retrofit2.Response
import javax.inject.Inject

class ChineseRepository @Inject constructor(
    private val chineseService: ChineseService,
    private val simplifiedService: SimplifiedService,
    private val englishService: EnglishService,
    private val koreanService: KoreanService,
    private val strokeService: StrokeService
) {
    suspend fun getbyCharacter(character:String): Response<ChineseDict>{
        return chineseService.getbyCharacter(character)
    }

    suspend fun convertText(
        converter: String,
        text: String,
        prettify: Int
    ): Response<SimplifiedChinese>{
        return simplifiedService.convertText(converter,text,prettify)
    }

    suspend fun getEnglishMeaning(
        character:String
    ): Response<EnglishDict>{
        return englishService.EnglishMeaning(character)
    }

    suspend fun getKoreanMeaning(
        character:String
    ): Response<KoreanDict>{
        return koreanService.KoreanMeaning(character)
    }

    suspend fun getStrokeOrder(character:String): Response<StrokeOrder>{
        return strokeService.getbyCharacter(character)
    }
}