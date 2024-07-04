package com.classic.character1000.viewmodel

import androidx.lifecycle.ViewModel
import com.classic.character1000.dictionary.CheonJaMun
import com.classic.character1000.dictionary.ThousandCharacterClassic
import com.classic.character1000.dictionary.ThousandCharacterClassicEnglish
import com.classic.character1000.network.ChineseRepository
import com.classic.character1000.network.ChineseService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    //private val chineseRepository: ChineseRepository
) : ViewModel(){
    val thousandCharacterClassic = ThousandCharacterClassic.getlist()
    val thousandCharacterClassicEng = ThousandCharacterClassicEnglish.getoriginaltext()
    val thousandCharacterClassicKor = CheonJaMun.getoriginaltext()
}
