package com.gudmal.storagemanagement.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.screens.login.components.LoginContent
import com.gudmal.storagemanagement.ui.screens.login.components.LoginStats
import com.gudmal.storagemanagement.utils.Utils.Companion.showMessage


@Composable
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
fun LoginScreen(
    viewModel: LoginScreenViewModel = hiltViewModel(),
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.surface)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginContent(
            login = { email, password ->
                viewModel.signInWithEmailAndPassword(email, password)
            }
        )
    }
    
    LoginStats(
        showErrorMessage = { errorMessage ->
            showMessage(context, errorMessage)
        }
    )
}