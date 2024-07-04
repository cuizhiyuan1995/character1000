package com.classic.character1000.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.classic.character1000.R


@Composable
fun IntroductionScreen(
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
                        openURL.data =
                            Uri.parse("https://baike.baidu.com/item/%E5%8D%83%E5%AD%97%E6%96%87/447586")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "千字文", fontSize = fontsize)
            Text(
                text = stringResource(R.string.chineseIntroduction),
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
                        openURL.data =
                            Uri.parse("https://en.wikipedia.org/wiki/Thousand_Character_Classic")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Thousand Character Classic", fontSize = fontsize)
            Text(
                text = stringResource(R.string.englishIntroduction),
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
                        openURL.data =
                            Uri.parse("https://namu.wiki/w/%EC%B2%9C%EC%9E%90%EB%AC%B8")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "천자문", fontSize = fontsize)
            Text(
                text = stringResource(R.string.koreanIntroduction),
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)
    }
}