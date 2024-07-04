package com.classic.character1000.dictionary

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChineseDict(
    val heteronyms: List<Heteronym> = listOf(),
    val non_radical_stroke_count: Int = 0,
    val radical: String = "",
    val stroke_count: Int = 0,
    val title: String = ""
) {
    data class Heteronym(
        val bopomofo: String = "",
        val bopomofo2: String = "",
        val definitions: List<Definition> = listOf(),
        val pinyin: String = ""
    ) {
        data class Definition(
            val def: String = "",
            val example: List<String> = listOf(),
            val link: List<String> = listOf(),
            val quote: List<String> = listOf(),
            val type: String = ""
        )
    }
}