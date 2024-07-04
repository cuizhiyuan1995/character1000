package com.classic.character1000.dictionary

data class EnglishDict(
    val input: String = "",
    val lang: String = "",
    val le: String = "",
    val meta: Meta = Meta(),
    val simple: Simple = Simple(),
    val wuguanghua: Wuguanghua = Wuguanghua()
) {
    data class Meta(
        val dicts: List<String> = listOf(),
        val guessLanguage: String = "",
        val input: String = "",
        val isHasSimpleDict: String = "",
        val lang: String = "",
        val le: String = ""
    )

    data class Simple(
        val query: String = "",
        val word: List<Word> = listOf()
    ) {
        data class Word(
            val phone: String = "",
            val returnphrase: String = ""
        )
    }

    data class Wuguanghua(
        val dataList: List<Data> = listOf(),
        val source: Source = Source(),
        val word: String = ""
    ) {
        data class Data(
            val phone: String = "",
            val speech: String = "",
            val trs: List<Tr> = listOf()
        ) {
            data class Tr(
                val pos: String = "",
                val sents: List<Sent> = listOf(),
                val tr: Tr = Tr()
            ) {
                data class Sent(
                    val cn: String = "",
                    val en: String = ""
                )

                data class Tr(
                    val cn: String = "",
                    val en: String = ""
                )
            }
        }

        data class Source(
            val name: String = ""
        )
    }
}