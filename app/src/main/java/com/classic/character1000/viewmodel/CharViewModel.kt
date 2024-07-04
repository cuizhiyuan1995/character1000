package com.classic.character1000.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.classic.character1000.dictionary.ChineseDict
import com.classic.character1000.dictionary.EnglishDict
import com.classic.character1000.dictionary.KoreanDict
import com.classic.character1000.dictionary.SimplifiedChinese
import com.classic.character1000.dictionary.StrokeOrder
import com.classic.character1000.dictionary.ThousandCharacterClassic
import com.classic.character1000.network.ChineseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharViewModel @Inject constructor (
    private val chineseRepository: ChineseRepository
) : ViewModel(){

    private val _chineseDict = MutableStateFlow(ChineseDict())
    val chineseDict : StateFlow<ChineseDict> = _chineseDict.asStateFlow()


    fun fetchCharfromDict(char: String) = viewModelScope.launch{
        val dictResponse = chineseRepository.getbyCharacter(char)
        Log.e("CharViewModel",dictResponse.toString())
        _chineseDict.value = dictResponse.body()!!
    }

    private val _simplifiedChinese = MutableStateFlow(SimplifiedChinese())
    val simplifiedChinese : StateFlow<SimplifiedChinese> = _simplifiedChinese.asStateFlow()

    fun fetchSimplifiedChinese(char: String) = viewModelScope.launch{
        val simpResponse = chineseRepository.convertText("Simplified",char,1)
        Log.e("CharViewModel",simpResponse.toString())
        if(simpResponse.body() != null){
            _simplifiedChinese.value = simpResponse.body()!!
        }
    }

    private val _englishMeaning = MutableStateFlow(EnglishDict())
    val englishMeaning : StateFlow<EnglishDict> = _englishMeaning.asStateFlow()

    fun fetchEnglishMeaning(char: String) = viewModelScope.launch{
        val engResponse = chineseRepository.getEnglishMeaning(char)
        Log.e("CharViewModel",engResponse.toString())
        if(engResponse.body() != null){
            _englishMeaning.value = engResponse.body()!!
        }
    }

    private val _koreanMeaning = MutableStateFlow(KoreanDict())
    val koreanMeaning : StateFlow<KoreanDict> = _koreanMeaning.asStateFlow()

    fun fetchKoreanMeaning(char: String) = viewModelScope.launch{
        val korResponse = chineseRepository.getKoreanMeaning(char)
        Log.e("CharViewModel",korResponse.toString())
        if(korResponse.body() != null){
            _koreanMeaning.value = korResponse.body()!!
            //Log.e("CharViewmodel",_koreanMeaning.value.toString())
        }
    }

    private val _strokeOrder = MutableStateFlow(StrokeOrder())
    val strokeOrder : StateFlow<StrokeOrder> = _strokeOrder.asStateFlow()

    fun fetchStrokeOrder(char: String) = viewModelScope.launch{
        val strokeResponse = chineseRepository.getStrokeOrder(char)
        Log.e("CharViewModel",strokeResponse.toString())
        if(strokeResponse.body() != null){
            _strokeOrder.value = strokeResponse.body()!!
        }
    }

    fun fetchAudioURL(pinyin:String):String{
         val vowels = listOf(
             "ā",
             "á",
             "ǎ",
             "à",
             "ō",
             "ó",
             "ǒ",
             "ò",
             "ē",
             "é",
             "ě",
             "è",
             "ī",
             "í",
             "ǐ",
             "ì",
             "ū",
             "ú",
             "ǔ",
             "ù",
             "ǖ",
             "ǘ",
             "ǚ",
             "ǜ"
         )
        val vowelNoTone = mapOf(
            "ā" to "a",
            "á" to "a",
            "ǎ" to "a",
            "à" to "a",
            "ō" to "o",
            "ó" to "o",
            "ǒ" to "o",
            "ò" to "o",
            "ē" to "e",
            "é" to "e",
            "ě" to "e",
            "è" to "e",
            "ī" to "i",
            "í" to "i",
            "ǐ" to "i",
            "ì" to "i",
            "ū" to "u",
            "ú" to "u",
            "ǔ" to "u",
            "ù" to "u",
            "ǖ" to "ü",
            "ǘ" to "ü",
            "ǚ" to "ü",
            "ǜ" to "ü"
        )

        val vowelToneNumber = mapOf(
            "ā" to "1",
            "á" to "2",
            "ǎ" to "3",
            "à" to "4",
            "ō" to "1",
            "ó" to "2",
            "ǒ" to "3",
            "ò" to "4",
            "ē" to "1",
            "é" to "2",
            "ě" to "3",
            "è" to "4",
            "ī" to "1",
            "í" to "2",
            "ǐ" to "3",
            "ì" to "4",
            "ū" to "1",
            "ú" to "2",
            "ǔ" to "3",
            "ù" to "4",
            "ǖ" to "1",
            "ǘ" to "2",
            "ǚ" to "3",
            "ǜ" to "4"
        )
        var currVowel = ""
        var currVowelWithoutTone = ""
        var currVowelToneNubmer = ""
        for(vowel in vowels){
            if(pinyin.contains(vowel)){
                currVowel = vowel
            }
        }
        if(vowelNoTone.containsKey(currVowel)){
            currVowelWithoutTone = vowelNoTone[currVowel].toString()
            currVowelToneNubmer = vowelToneNumber[currVowel].toString()
        }
        val pinyinWithoutTone = pinyin.replace(currVowel, currVowelWithoutTone)

        //val url = "https://hanyu-word-pinyin-short.cdn.bcebos.com/" + pinyinWithoutTone + currVowelToneNubmer + ".mp3"
        val url = "https://resources.allsetlearning.com/pronwiki/resources/pinyin-audio/" + pinyinWithoutTone + currVowelToneNubmer + ".mp3"
        return  url
    }

}