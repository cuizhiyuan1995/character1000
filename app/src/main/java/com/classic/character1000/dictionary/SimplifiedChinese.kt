package com.classic.character1000.dictionary

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SimplifiedChinese(
    val code: Int = 0,
    val data: Data = Data(),
    val execTime: Double = 0.0,
    val msg: String = "",
    val revisions: Revisions = Revisions()
) {
    data class Data(
        val converter: String = "",
        val diff: String? = "",
        val jpTextStyles: List<Any> = listOf(),
        val text: String = "",
        val textFormat: String = "",
        val usedModules: List<String> = listOf()
    )

    data class Revisions(
        val build: String = "",
        val msg: String = "",
        val time: Int = 0
    )
}