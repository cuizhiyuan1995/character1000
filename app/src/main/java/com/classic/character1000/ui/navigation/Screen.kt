package com.classic.character1000.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home_screen")
    object Char : Screen(route = "char_screen")
    object Settings: Screen(route = "settings_screen")
    object Version: Screen(route = "version_screen")
    object DataSource: Screen(route = "datasource_screen")
    object Introduction: Screen(route = "introduction_screen")
    object Calligraphy: Screen(route = "calligraphy_screen")
}
