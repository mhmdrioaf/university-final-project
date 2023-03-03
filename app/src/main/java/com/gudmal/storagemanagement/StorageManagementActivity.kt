package com.gudmal.storagemanagement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.gudmal.storagemanagement.utils.navigation.NavGraph
import com.gudmal.storagemanagement.utils.navigation.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class StorageManagementActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val viewModel by viewModels<StorageManagementViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberAnimatedNavController()
            NavGraph(navController = navController)
            AuthState()
        }
    }

    @Composable
    private fun AuthState() {
        val isUserSignedOut = viewModel.getAuthSatate().collectAsState().value
        if (isUserSignedOut) {
            NavigateToLoginScreen()
        } else {
            NavigateToDashboardScreen()
        }
    }

    @Composable
    private fun NavigateToDashboardScreen() = navController.navigate(Screen.DashboardScreenRoute.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }

    @Composable
    private fun NavigateToLoginScreen() = navController.navigate(Screen.LoginScreenRoute.route) {
        popUpTo(navController.graph.id) {
            inclusive = true
        }
    }
}