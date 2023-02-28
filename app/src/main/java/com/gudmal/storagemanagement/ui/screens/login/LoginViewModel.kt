package com.gudmal.storagemanagement.ui.screens.login

import androidx.compose.runtime.mutableStateOf
import com.gudmal.storagemanagement.DASHBOARD_SCREEN
import com.gudmal.storagemanagement.LOGIN_SCREEN
import com.gudmal.storagemanagement.R.string as AppText
import com.gudmal.storagemanagement.model.service.AccountService
import com.gudmal.storagemanagement.model.service.LogService
import com.gudmal.storagemanagement.ui.screens.StorageManagementViewModel
import com.gudmal.storagemanagement.utils.ext.isValidEmail
import com.gudmal.storagemanagement.utils.snackbar.SnackbarManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LogService
) : StorageManagementViewModel(logService) {
    var uiState = mutableStateOf(LoginUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.password
    private val isLoading
        get() = uiState.value.isLoading

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(password = newValue)
    }

    fun onSignInClick(openAndPopup: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage(AppText.email_error)
            return
        }

        if (password.isBlank()) {
            SnackbarManager.showMessage(AppText.empty_password_error)
            return
        }

        launchCatching {
            accountService.authenticate(email, password)
            openAndPopup(DASHBOARD_SCREEN, LOGIN_SCREEN)
        }
    }
}