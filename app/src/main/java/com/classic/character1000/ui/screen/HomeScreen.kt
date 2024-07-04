package com.classic.character1000.ui.screen

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.classic.character1000.viewmodel.HomeViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.classic.character1000.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Text("1000Characters")
                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {

                    IconButton(onClick = {
                        navController.navigate(Screen.Settings.route)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = "Settings"
                        )
                    }
                },
                modifier = Modifier.height(40.dp),

            )
        },
//                    floatingActionButton = {
//                        FloatingActionButton(onClick = { presses++ }) {
//                            Icon(Icons.Default.Add, contentDescription = "Add")
//                        }
//                    }
    ) { innerPadding ->
        val charlist = viewModel.thousandCharacterClassic
        val charlist_eng = viewModel.thousandCharacterClassicEng
        val charlist_kor = viewModel.thousandCharacterClassicKor
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Bottom
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(9),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(charlist.size * 9 / 8) { index ->
                    val originalIndex = index - (index + 4) / 9
                    val modifier = if(index % 9 != 4){
                        Modifier.clickable {
                            navController.navigate(Screen.Char.route + "/" + charlist[originalIndex].toString())
                        }
                    }
                    else{
                        Modifier
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = modifier
                            .border(BorderStroke(2.dp, Color.DarkGray))
                        //.height(100.dp)
                    ) {
                        if(index % 9 != 4){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                    //.border(BorderStroke(2.dp, Color.Red))
                                ) {
                                    Text(
                                        text = charlist_eng[originalIndex],
                                        fontSize = 10.sp,
                                        lineHeight = 10.sp,
                                        maxLines = 1
                                    )
                                }

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .border(BorderStroke(2.dp, Color.LightGray))
                                        .fillMaxWidth()
                                ) {
                                    Text(
                                        text = charlist[originalIndex].toString(),
                                        //style = MaterialTheme.typography.headlineMedium,
                                        fontSize = 30.sp,
                                    )
                                }

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                    //.border(BorderStroke(2.dp, Color.Red))
                                ) {
                                    Text(
                                        text = charlist_kor[originalIndex],
                                        fontSize = 10.sp,
                                        lineHeight = 10.sp,
                                        //modifier = Modifier.height(20.dp)
                                    )
                                }

                            }


                        }
                    }
                }
            }
        }
    }

}

//@Composable
//fun HalfVerticalGrid(
//    leftorRight: Int,
//    charlist:List<Char>,
//    navController: NavHostController,
//){
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(4),
//        modifier = Modifier.fillMaxSize(),
//        contentPadding = PaddingValues(8.dp)
//    ) {
//        items(charlist.size / 2 ) { index ->
//            val originalIndex = (index/4) * 4 + index + (leftorRight * 4)
//            Box(
//                contentAlignment = Alignment.Center,
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(Screen.Char.route + "/" + charlist[originalIndex].toString())
//                    }
//                    .border(BorderStroke(2.dp, Color.Red))
//                    .height(50.dp)
//            ) {
//                Text(
//                    text = charlist[originalIndex].toString(),
//                    style = MaterialTheme.typography.bodyLarge,
//                )
//            }
//        }
//    }
//}