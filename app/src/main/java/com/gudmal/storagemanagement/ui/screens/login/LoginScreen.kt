package com.gudmal.storagemanagement.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gudmal.storagemanagement.ui.components.buttons.PrimaryButton
import com.gudmal.storagemanagement.ui.components.inputs.EmailInput
import com.gudmal.storagemanagement.ui.components.inputs.PasswordInput
import com.gudmal.storagemanagement.R.drawable as AppImage
import com.gudmal.storagemanagement.R.string as AppText
import com.gudmal.storagemanagement.R.color as AppColor


@Composable
fun TitleText(text: String) {
    Text(text = text, fontSize = 34.sp)
}

@Composable
fun MainLoginScreen(
    openAndPopUp: (String, String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState

    /* TODO: Add loading indicator when user pressed sign-in button. */

    // screen content container
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(space = 64.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // company logo
        Image(
            painter = painterResource(AppImage.gudmal_logo),
            contentDescription = stringResource(AppText.image_company_logo_content_description),
            colorFilter = ColorFilter.tint(colorResource(AppColor.primary))
        )

        // screen title
        TitleText(text = stringResource(AppText.login_title))

        // textfield container
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // email input
            EmailInput(
                value = uiState.email,
                onNewValue = viewModel::onEmailChange,
                modifier = Modifier
            )

            // password input
            PasswordInput(
                value = uiState.password,
                onNewValue = viewModel::onPasswordChange,
                modifier = Modifier
            )
        }

        // login button
        PrimaryButton(text = stringResource(AppText.login_button_text), modifier = Modifier.fillMaxWidth().height(48.dp)) { viewModel.onSignInClick(openAndPopUp) }

        /* TODO: Add forgot password button. */

        /* TODO: Add sign-in anonymously option. */
    }
}