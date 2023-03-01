package com.gudmal.storagemanagement.ui.screens.login.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.gudmal.storagemanagement.model.Response
import com.gudmal.storagemanagement.ui.components.common.ProgressBar
import com.gudmal.storagemanagement.ui.screens.login.LoginScreenViewModel

@Composable
fun LoginStats(
    viewModel: LoginScreenViewModel = hiltViewModel(),
    showErrorMessage: (errorMessage: String?) -> Unit
) {
    when (val signInResponse = viewModel.signInResponse) {
        is Response.Loading -> ProgressBar()
        is Response.Success -> Unit
        is Response.Failure -> signInResponse.apply {
            print(e)
            showErrorMessage(e.message)
        }

    }
}