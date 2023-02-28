package com.gudmal.storagemanagement.utils.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gudmal.storagemanagement.ui.screens.Screen
import com.gudmal.storagemanagement.ui.screens.dashboard.DashboardScreen
import com.gudmal.storagemanagement.ui.screens.login.MainLoginScreen

@Composable
fun Navigation() {

    /* TODO: Prevent go back to the login screen. */

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    ) {

        composable(route = Screen.LoginScreen.route) {
            MainLoginScreen(modifier = Modifier, navController = navController)
        }

        composable(route = Screen.DashboardScreen.route) {
            DashboardScreen(navController = navController)
        }
    }
}