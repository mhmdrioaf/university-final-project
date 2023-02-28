package com.gudmal.storagemanagement.ui.screens

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object DashboardScreen: Screen("dashboard_screen")
}
