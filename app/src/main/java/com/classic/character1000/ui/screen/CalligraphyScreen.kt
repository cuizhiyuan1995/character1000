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
fun CalligraphyScreen(
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
                            Uri.parse("http://qsshc.mond.jp/cpoem/qianziwentate.html")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "ZhenCaoQianZiWen", fontSize = fontsize)
            Text(
                text = "ZhiYong, Sui Dynasty, Regular and Cursive Style, Personal Collector in Japan",
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
                            Uri.parse("https://learning.hku.hk/ccch9051/group-24/items/show/46")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "CaoShu QianZiWen", fontSize = fontsize)
            Text(
                text = "Emperor Huizong Zhaoji, Song Dynasty(AD1122), Cursive Style, Liaoning Provincial Museum",
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
                            Uri.parse("https://www.sohu.com/a/664923125_121617066")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "XiaoCao QianZiWen", fontSize = fontsize)
            Text(
                text = "Huaisu, Tang Dynasty(AD799), Small Cursive Style, Personal Collector",
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
                            Uri.parse("https://www.sohu.com/a/583164081_121124804")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "DaCao QianZiWen", fontSize = fontsize)
            Text(
                text = "Huaisu, Tang Dynasty(AD767), Big Cursive Style, Personal Collector in US",
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
                            Uri.parse("https://www.sohu.com/a/227021243_100115184")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Xingshu QianZiWen", fontSize = fontsize)
            Text(
                text = "Zhao Mengfu, Yuan Dynasty, Running Style, Palace Museum",
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
                            Uri.parse("https://da.dl.itc.u-tokyo.ac.jp/portal/assets/0be13c27-8bff-467a-abba-5dfd37b5c436?pos=49")
                        context.startActivity(openURL)
                    }
                )
        ) {
            Text(text = "Cheonjamun Naesa", fontSize = fontsize)
            Text(
                text = "Han Ho, Joseon Dynasty(AD1583), Regular Style, National Archives of Japan",
                fontSize = fontsize,
                color = Color.Gray
            )
        }
        //end of Data block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

    }
}