package com.gudmal.storagemanagement.utils.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.gudmal.storagemanagement.ui.screens.dashboard.DashboardScreen
import com.gudmal.storagemanagement.ui.screens.login.LoginScreen

@Composable
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
fun NavGraph(
    navController: NavHostController
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.LoginScreenRoute.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        composable(
            route = Screen.LoginScreenRoute.route
        ) {
            LoginScreen()
        }

        composable(
            route = Screen.DashboardScreenRoute.route
        ) {
            DashboardScreen()
        }
    }
}