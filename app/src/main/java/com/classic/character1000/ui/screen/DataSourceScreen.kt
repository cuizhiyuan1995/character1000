package com.classic.character1000.ui.screen

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.classic.character1000.R

@Composable
fun DataSourceScreen(
    navController: NavHostController
) {
    val padding = 16.dp
    val fontsize = 15.sp
    val context = LocalContext.current

    Column(
        Modifier
            .fillMaxHeight()
            .background(color = Color.LightGray)
            .verticalScroll(rememberScrollState())
    ) {

        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://docs.zhconvert.org/api/convert/")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Simplified Chinese Convert API", fontSize = fontsize)
            Text(
                text = "ZH繁化姬",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://github.com/g0v/moedict-webkit/?tab=readme-ov-file")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Chinese Explanation API", fontSize = fontsize)
            Text(
                text = "Moedict萌典",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://github.com/shichunlei/-Api/blob/master/YoudaoDic.md#explain")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "English Explanation API", fontSize = fontsize)
            Text(
                text = "有道youdao",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)


        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://dict.youdao.com   /jsonapi?q=%E5%8D%83&le=ko")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Korean Explanation API", fontSize = fontsize)
            Text(
                text = "有道youdao",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://chanind.github.io/hanzi-writer-data")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Stroke Order API", fontSize = fontsize)
            Text(
                text = "Hanzi Writer Data Explorer",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //Data block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        val openURL = Intent(Intent.ACTION_VIEW)
                        openURL.data = Uri.parse("https://resources.allsetlearning.com/pronwiki/resources/pinyin-audio/")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Pronunciation API", fontSize = fontsize)
            Text(
                text = "Allsetlearning Chinese Pronunciation Wiki",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)


        //Data block
        val annotatedString = buildAnnotatedString {

            pushStringAnnotation(tag = "TCCWiki", annotation = "https://en.wikipedia.org/wiki/Thousand_Character_Classic")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Thousand Character Classic Wikipedia")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "StrokeGithub", annotation = "https://github.com/chanind/hanzi-writer-data?tab=readme-ov-file")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Hanzi Writer Data Github")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "StrokeAnimation", annotation = "https://juejin.cn/post/7103192601515425823#heading-4")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Stroke Animation")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "StrokeAnimationGit", annotation = "https://github.com/zuo26/BlogSample/blob/master/app/src/main/java/com/blog/demo41/StrokeOrderView.kt#L79")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Stroke Animation Github")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "ComposeAnimationMedium", annotation = "https://realsoc.medium.com/drawing-with-compose-the-animated-string-path-2dfa14af0739")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Drawing with Compose : The Animated String Path")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "ComposeAnimationStackOverflow", annotation = "https://stackoverflow.com/questions/75680892/how-to-animate-drawpath-on-jetpack-compose-canvas")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("How to animate drawPath() on jetpack compose canvas")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "ChatGPT", annotation = "https://chatgpt.com/")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("ChatGPT")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "ChineseExplanationMedium", annotation = "https://medium.com/%E5%BD%BC%E5%BE%97%E6%BD%98%E7%9A%84%E8%A9%A6%E7%85%89-%E5%8B%87%E8%80%85%E7%9A%84-100-%E9%81%93-swift-ios-app-%E8%AC%8E%E9%A1%8C/209-%E4%B8%B2%E6%8E%A5%E8%90%8C%E5%85%B8-api-%E9%96%8B%E7%99%BC%E5%AD%97%E5%85%B8-app-a0069a4345bd")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("#209 串接萌典 API 開發字典 App")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "TCCNamuWiki", annotation = "https://namu.wiki/w/%EC%B2%9C%EC%9E%90%EB%AC%B8")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("NamuWiki천자문")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "TCCKorean", annotation = "https://blog.naver.com/PostView.nhn?blogId=mgjang1&logNo=220298683329")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("NaverBlog천자문")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "YoudaoChinesetoKorean", annotation = "https://dict.youdao.com/result?word=%E5%A4%A9&lang=ko")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("有道youdao中韩")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "PopupScreenMedium", annotation = "https://medium.com/@itsuki.enjoy/android-kotlin-jetpack-compose-popup-window-b011cacd9e7d")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Android/Kotlin/Jetpack Compose: Popup Window")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "DictionaryYoutube", annotation = "https://www.youtube.com/watch?v=LM5lWetuCHo&t=1693s")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("How to make Dictionary app | Android Studio | 2024")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "JsonToKotlinClassGit", annotation = "https://github.com/wuseal/JsonToKotlinClass?tab=readme-ov-file")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("JsonToKotlinClass")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "HiltRetrofitYoutube", annotation = "https://www.youtube.com/watch?v=23Gj0z88H2U")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("Android Dependency Injection: Hilt + Retrofit")
            }
            pop()
            append("\n")

            pushStringAnnotation(tag = "AnimationDrawPathStackOverflow", annotation = "https://stackoverflow.com/questions/75680892/how-to-animate-drawpath-on-jetpack-compose-canvas")
            withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append("How to animate drawPath() on jetpack compose canvas")
            }
            pop()
            append("\n")

        }

        val uriHandler = LocalUriHandler.current

        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Text(text = "Other Reference Resources", fontSize = fontsize)
//            Text(
//                text = "Allsetlearning Chinese Pronunciation Wiki",
//                fontSize = fontsize,
//                color = Color.Gray
//            )
            ClickableText(text = annotatedString, style = MaterialTheme.typography.bodyLarge, onClick = { offset ->
                annotatedString.getStringAnnotations(tag = "TCCWiki", start = offset, end = offset).firstOrNull()?.let {
                    Log.d("TCCWiki", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "StrokeGithub", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "StrokeAnimation", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "StrokeAnimationGit", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "ComposeAnimationMedium", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "ComposeAnimationStackOverflow", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "ChatGPT", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "ChineseExplanationMedium", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "TCCNamuWiki", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "TCCKorean", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "YoudaoChinesetoKorean", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "PopupScreenMedium", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "DictionaryYoutube", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "JsonToKotlinClassGit", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "HiltRetrofitYoutube", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }

                annotatedString.getStringAnnotations(tag = "AnimationDrawPathStackOverflow", start = offset, end = offset).firstOrNull()?.let {
                    //Log.d("terms URL", it.item)
                    uriHandler.openUri(it.item)
                }


            })
        }
        //end of Data block

    }
}