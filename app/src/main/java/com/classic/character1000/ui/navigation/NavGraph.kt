package com.classic.character1000.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.classic.character1000.ui.screen.CalligraphyScreen
import com.classic.character1000.ui.screen.CharScreen
import com.classic.character1000.ui.screen.DataSourceScreen
import com.classic.character1000.ui.screen.HomeScreen
import com.classic.character1000.ui.screen.IntroductionScreen
import com.classic.character1000.ui.screen.SettingsScreen
import com.classic.character1000.ui.screen.VersionScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String
){
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Char.route + "/{char}",
            arguments = listOf(navArgument("char"){type = NavType.StringType})
        ){
            CharScreen(
                navController = navController,
                currchar = it.arguments?.getString("char") ?: ""
            )
        }
        composable(route = Screen.Settings.route){
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.Version.route){
            VersionScreen(navController = navController)
        }
        composable(route = Screen.DataSource.route){
            DataSourceScreen(navController = navController)
        }
        composable(route = Screen.Introduction.route){
            IntroductionScreen(navController = navController)
        }
        composable(route = Screen.Calligraphy.route){
            CalligraphyScreen(navController = navController)
        }
    }
}