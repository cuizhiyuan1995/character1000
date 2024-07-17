package com.classic.character1000.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun VersionScreen(
    navController: NavHostController
) {
    val padding = 16.dp
    val fontsize = 15.sp
    Column(
        Modifier
            .fillMaxHeight()
            .background(color = Color.LightGray)
    ) {

        //version block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .padding(padding)
                //.fillMaxWidth()
            ) {
                Text(text = "v1.0.2", fontSize = fontsize)
                Text(text = "07/17/2024", fontSize = fontsize)
                Text(text = "Bug", fontSize = fontsize)
                Text(text = "Fix support for Android 11", fontSize = fontsize, color = Color.Gray)
            }
        }
        //end of version block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //version block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .padding(padding)
                //.fillMaxWidth()
            ) {
                Text(text = "v1.0.1", fontSize = fontsize)
                Text(text = "07/11/2024", fontSize = fontsize)
                Text(text = "Feature", fontSize = fontsize)
                Text(text = "Add support for Android 11", fontSize = fontsize, color = Color.Gray)
            }
        }
        //end of version block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //version block
        Column(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
        ) {
            Column(
                Modifier
                    .padding(padding)
                //.fillMaxWidth()
            ) {
                Text(text = "v1.0.0", fontSize = fontsize)
                Text(text = "07/04/2024", fontSize = fontsize)
                Text(text = "Feature", fontSize = fontsize)
                Text(text = "first version", fontSize = fontsize)
                Text(text = "HomeScreen shows all the characters", fontSize = fontsize, color = Color.Gray)
                Text(text = "DetailedScreen shows explanation of every characters in 3 languages", fontSize = fontsize, color = Color.Gray)
                Text(text = "DetailedScreen shows stroke order and pronunciation", fontSize = fontsize, color = Color.Gray)
            }
        }
        //end of version block

        //Divider(color = Color.LightGray, thickness = 4.dp)
    }
}