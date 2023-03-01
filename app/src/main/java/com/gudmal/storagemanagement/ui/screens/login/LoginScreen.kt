package com.gudmal.storagemanagement.ui.screens.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.gudmal.storagemanagement.ui.screens.login.components.LoginContent
import com.gudmal.storagemanagement.ui.screens.login.components.LoginStats
import com.gudmal.storagemanagement.utils.Utils.Companion.showMessage


@Composable
@ExperimentalComposeUiApi
fun LoginScreen(
    viewModel: LoginScreenViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    LoginContent(
        login = { email, password ->
            viewModel.signInWithEmailAndPassword(email, password)
        }
    )
    
    LoginStats(
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}