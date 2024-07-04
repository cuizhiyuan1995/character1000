package com.classic.character1000.dictionary

import com.fasterxml.jackson.annotation.JsonAlias
import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import com.squareup.moshi.Json

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class KoreanDict(
    val baike: Baike = Baike(),
    val blng_sents_part: BlngSentsPart = BlngSentsPart(),
    val ck: Ck = Ck(),
    val input: String = "",
    val lang: String = "",
    val le: String = "",
    @Json(name = "longchao-ck") val longchaock: LongchaoCk = LongchaoCk(),
    val meta: Meta = Meta(),
    val simple: Simple = Simple(),
    val web_trans: WebTrans = WebTrans()
) {
    data class Baike(
        val source: Source = Source(),
        val summarys: List<Summary> = listOf()
    ) {
        data class Source(
            val name: String = "",
            val url: String = ""
        )

        data class Summary(
            val key: String = "",
            val summary: String = ""
        )
    }

    data class BlngSentsPart(
        val more: String = "",
        @JsonProperty("sentence-count")  val sentencecount: Int = 0,
        @JsonProperty("sentence-pair")val sentencepair: List<SentencePair> = listOf()
    ) {
        data class SentencePair(
            val sentence: String = "",
            @JsonProperty("sentence-eng")val sentenceeng: String = "",
            @JsonProperty("sentence-translation")val sentencetranslation: String = "",
            @JsonProperty("sentence-translation-speech")val sentencetranslationspeech: String = "",
            @JsonProperty("speech-size")val speechsize: String = "",
            val url: String = ""
        )
    }

    data class Ck(
        val source: Source = Source(),
        val word: List<Word> = listOf()
    ) {
        data class Source(
            val name: String = "",
            val url: String = ""
        )

        data class Word(
            val phone: String = "",
            @JsonProperty("return-phrase") val returnphrase: ReturnPhrase = ReturnPhrase(),
            val trs: List<Tr> = listOf()
        ) {
            data class ReturnPhrase(
                val l: L = L()
            ) {
                data class L(
                    val i: String = ""
                )
            }

            data class Tr(
                val pos: String = "",
                val tr: List<Tr> = listOf()
            ) {
                data class Tr(
                    val exam: Exam = Exam(),
                    val l: L = L()
                ) {
                    data class Exam(
                        val i: List<I> = listOf()
                    ) {
                        data class I(
                            val f: F = F(),
                            val n: N = N()
                        ) {
                            data class F(
                                val l: L = L()
                            ) {
                                data class L(
                                    val i: List<String> = listOf()
                                )
                            }

                            data class N(
                                val l: L = L()
                            ) {
                                data class L(
                                    val i: String = ""
                                )
                            }
                        }
                    }

                    data class L(
                        val i: List<String> = listOf()
                    )
                }
            }
        }
    }

    data class LongchaoCk(
        val dataList: List<Data> = listOf(),
        val source: Source = Source(),
        val word: String = ""
    ) {
        data class Data(
            val meanings: Meanings = Meanings(),
            val pinyin: String = "",
            @JsonAlias("traditional-word") val traditionalword: String = "",
            val voice: String = "",
            val word: String = ""
        ) {
            data class Meanings(
                val sense: List<Sense> = listOf()
            ) {
                data class Sense(
                    val trs: List<Tr> = listOf()
                ) {
                    data class Tr(
                        val pos: String = "",
                        val sentences: List<Sentence> = listOf(),
                        val tr: String = ""
                    ) {
                        data class Sentence(
                            val cn: String = "",
                            val ko: String = ""
                        )
                    }
                }
            }
        }

        data class Source(
            val name: String = ""
        )
    }

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
            @JsonProperty("return-phrase")val returnphrase: String = ""
        )
    }

    data class WebTrans(
        @JsonProperty("web-translation")val webtranslation: List<WebTranslation> = listOf()
    ) {
        data class WebTranslation(
            val key: String = "",
            val trans: List<Tran> = listOf()
        ) {
            data class Tran(
                val value: String = ""
            )
        }
    }
}