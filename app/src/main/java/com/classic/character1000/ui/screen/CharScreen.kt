package com.classic.character1000.ui.screen

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.SimpleExoPlayer
import androidx.navigation.NavHostController
import com.classic.character1000.viewmodel.CharViewModel
import com.classic.character1000.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

@Composable
fun  CharScreen(
    navController: NavHostController,
    viewModel: CharViewModel = hiltViewModel(),
    currchar : String
) {
    val chineseDict by viewModel.chineseDict.collectAsStateWithLifecycle()
    val simplifiedChinese by viewModel.simplifiedChinese.collectAsStateWithLifecycle()
    val englishMeaning by viewModel.englishMeaning.collectAsStateWithLifecycle()
    val koreanMeaning by viewModel.koreanMeaning.collectAsStateWithLifecycle()
    val strokeOrder by viewModel.strokeOrder.collectAsStateWithLifecycle()
    val context = LocalContext.current
//    val mediaPlayer = MediaPlayer()
//    mediaPlayer.setAudioAttributes(
//        AudioAttributes.Builder()
//            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//            .build()
//    )
    //val exoPlayer = ExoPlayer.Builder(context).build()

    //Log.e("CharScreen",chineseDict.heteronyms.toString())



    LaunchedEffect(Unit) {
        viewModel.fetchCharfromDict(currchar)
        viewModel.fetchSimplifiedChinese(currchar)
        viewModel.fetchEnglishMeaning(currchar)
        viewModel.fetchKoreanMeaning(currchar)
    }

    

    Log.e("CharScreen",englishMeaning.toString())

    val chineseMeaningList = chineseDict.heteronyms
    val englishTranslationList = englishMeaning.wuguanghua.dataList
    val koreanTranslationList = koreanMeaning.longchaock.dataList
    var showPopup by rememberSaveable { mutableStateOf(false) }

    if(
        chineseDict.title.isNotEmpty()
        and
        englishMeaning.input.isNotEmpty()
        and
        koreanMeaning.input.isNotEmpty()
        and
        simplifiedChinese.data.text.isNotEmpty()
        ){
        LazyColumn {

            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = chineseDict.title,
                        modifier = Modifier.align(Alignment.TopCenter),
                        fontSize = 80.sp,
                    )
                }
            }

            item {

                CharDivider()

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Tranditional Chinese: ",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = chineseDict.title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    IconButton(
                        onClick = {
                            showPopup = true
                            viewModel.fetchStrokeOrder(chineseDict.title)
                        },
                        modifier = Modifier.border(BorderStroke(2.dp, Color.Black))
                            .size(20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "StrokeOrder",
                            tint = Color(0xFF039be5),
                            modifier = Modifier.height(20.dp)
                        )
                    }
//                    Button(
//                        onClick = {
//                            showPopup = true
//                            viewModel.fetchStrokeOrder(chineseDict.title)
//                        }
//                    ) {
//                        Text(text = "Stroke Order")
//                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                )  {
                    Text(text = "Simplified Chinese: ",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(text = simplifiedChinese.data.text,
                        style = MaterialTheme.typography.titleMedium
                    )
                    IconButton(
                        onClick = {
                            showPopup = true
                            viewModel.fetchStrokeOrder(simplifiedChinese.data.text)
                        },
                        modifier = Modifier.border(BorderStroke(2.dp, Color.Black))
                            .size(20.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "StrokeOrder",
                            tint = Color(0xFF039be5),
                            modifier = Modifier.height(20.dp)
                        )
                    }
//                    Button(
//                        onClick = {
//                            showPopup = true
//                            viewModel.fetchStrokeOrder(simplifiedChinese.data.text)
//                        }
//                    ) {
//                        Text(text = "Stroke Order")
//                    }
                }
            }




            if(chineseDict.heteronyms.isNotEmpty()){

                item {
                    CharDivider()
                }

                items(chineseMeaningList){chineseItem->

                    var audioURL = ""

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(text = "Pinyin: ",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = chineseItem.pinyin,
                            style = MaterialTheme.typography.titleMedium
                        )
                        IconButton(
                            onClick = {
                                val exoPlayer = ExoPlayer.Builder(context).build()
                                audioURL = viewModel.fetchAudioURL(chineseItem.pinyin)
                                Log.e("CharScreen_Audio",audioURL)
                                val mediaItem = MediaItem.fromUri(Uri.parse(audioURL))
                                Log.e("CharScreen_Audio", mediaItem.mediaMetadata.toString())
                                exoPlayer.addMediaItem(mediaItem)
                                Log.e("CharScreen_Audio","AddMediaItem")
                                exoPlayer.prepare()
                                Log.e("CharScreen_Audio","Prepare")
                                exoPlayer.play()
                                Log.e("CharScreen_Audio","Play")
                            },
                            modifier = Modifier.border(BorderStroke(2.dp, Color.Black))
                                .size(20.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "StrokeOrder",
                                tint = Color(0xFF039be5),
                                modifier = Modifier.height(20.dp)
                            )
                        }
                    }

                    var index : Int = 1
                    for(subitem in chineseItem.definitions) {
                        if(subitem.def != ""){
                            Text(text = (index).toString() + "." + subitem.def)
                            index += 1
                        }
                    }
                }
            }


            if(englishMeaning.wuguanghua.dataList.isNotEmpty()){
                item {
                    CharDivider()
                    Text(
                        text = "English: ",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                var index : Int = 1

                items(englishTranslationList){translateItem->
                    //Text(text = translateItem.tr.en)

                    for(subitem in translateItem.trs) {
                        if(subitem.tr.en != ""){
                            Text(text = (index).toString() + "." + subitem.tr.en)
                            index += 1
                        }
                    }
                }
            }

            if(koreanMeaning.longchaock.dataList.isNotEmpty()){
                item {
                    CharDivider()
                    Text(
                        text = "Korean: ",
                        style = MaterialTheme.typography.titleMedium
                    )
                }


                var index2 = 1
                items(koreanTranslationList){translateItem->
                    //Text(text = translateItem.tr.en)
                    for(subitem in translateItem.meanings.sense.first().trs) {
                        if(subitem.tr != ""){
                            Text(
                                text = (index2).toString() + "." + subitem.tr
                            )
                            index2 += 1
                            //Log.e("CharScreen_Kor",subitem.tr)
                        }
                    }
                }
            }
        }
    }


    PopupScreen(
        popupWidth = 300F,
        popupHeight = 300F,
        showPopup = showPopup,
        onClickOutside = {showPopup = false},
        content = {
            StrokeScreen(strokeOrder = strokeOrder)
        }
    )


}

@Composable
fun CharDivider(){
    HorizontalDivider(thickness = 10.dp, color = Color.LightGray)
}