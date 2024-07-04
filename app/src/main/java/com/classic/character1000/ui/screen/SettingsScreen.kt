package com.classic.character1000.ui.screen

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.classic.character1000.ui.navigation.Screen
import com.classic.character1000.viewmodel.HomeViewModel
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity

@Composable
fun  SettingsScreen(
    navController: NavHostController
) {
    val padding = 16.dp
    val fontsize = 20.sp

    Column(
        Modifier
            .fillMaxHeight()
            .background(color = Color.LightGray)
    ) {
        val context = LocalContext.current
        val view = LocalView.current

        //block
        Row(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        //view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToVersionlogFragment())
                        navController.navigate(Screen.Introduction.route)
                    }
                )
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                //.fillMaxWidth()
            ) {
                Text(text = "What is 1000 Character Classic", fontSize = fontsize)
                Text(
                    text = "Click to view definition in multiple languages",
                    fontSize = fontsize,
                    color = Color.Gray
                )
            }

            //Icon(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription = null)

        }
        //end of block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //block
        Row(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        //view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToVersionlogFragment())
                        navController.navigate(Screen.Calligraphy.route)
                    }
                )
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                //.fillMaxWidth()
            ) {
                Text(text = "Calligraphy Masterpiece", fontSize = fontsize)
                Text(
                    text = "Click to view calligraphy work from calligraphers",
                    fontSize = fontsize,
                    color = Color.Gray
                )
            }

            //Icon(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription = null)

        }
        //end of block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //block
        Row(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        //view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToVersionlogFragment())
                        navController.navigate(Screen.Version.route)
                    }
                )
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                //.fillMaxWidth()
            ) {
                Text(text = "Version", fontSize = fontsize)
                Text(
                    text = stringResource(com.classic.character1000.R.string.app_version),
                    fontSize = fontsize,
                    color = Color.Gray
                )
            }

            //Icon(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription = null)

        }
        //end of block

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)

        //block 2

        Row(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        //view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToVersionlogFragment())
                        navController.navigate(Screen.DataSource.route)
                    }
                )
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Data Source", fontSize = fontsize)

            //Icon(painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24), contentDescription = null)

        }

        //end of block2

        HorizontalDivider(thickness = 4.dp, color = Color.LightGray)


        //block 3

        Row(
            Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .clickable(
                    onClick = {
                        //view.findNavController().navigate(AboutFragmentDirections.actionAboutFragmentToVersionlogFragment())
                        context.startActivity(Intent(context, OssLicensesMenuActivity::class.java))
                    }
                )
                .padding(padding),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                //.fillMaxWidth()
            ){
                Text(text = "Open Source",fontSize = fontsize)
            }

        }

        //end of block3
    }
}