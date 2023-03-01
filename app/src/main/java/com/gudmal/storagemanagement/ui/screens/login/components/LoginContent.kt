package com.gudmal.storagemanagement.ui.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.components.buttons.PrimaryButton
import com.gudmal.storagemanagement.ui.components.common.TitleText
import com.gudmal.storagemanagement.ui.components.inputs.EmailField
import com.gudmal.storagemanagement.ui.components.inputs.PasswordField

@Composable
@ExperimentalComposeUiApi
fun LoginContent(
    login: (email: String, password: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue("")) }
    var password by rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) { mutableStateOf(TextFieldValue("")) }
    val keyboard = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.spacedBy(56.dp)
    ) {

        // company logo
        Image(
            painter = painterResource(id = R.drawable.gudmal_logo),
            contentDescription = stringResource(id = R.string.img_desc_company_logo),
            colorFilter = ColorFilter.tint(colorResource(id = R.color.primary)),
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 68.dp, height = 85.dp)
        )

        // login screen title
        TitleText(
            text = stringResource(id = R.string.login),
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        // text input sections
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            EmailField(
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 4.dp),
                email = email,
                onEmailValueChange = { newValue ->
                    email = newValue
                }
            )
            PasswordField(
                modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                password = password,
                onPasswordValueChange = { newValue ->
                    password = newValue
                }
            )
        }

        // button
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PrimaryButton(
                text = stringResource(id = R.string.login),
                modifier = modifier
                    .fillMaxWidth()
                    .height(53.dp)
            ) {
                keyboard?.hide()
                login(email.text, password.text)

            }
            Row {
                Text(text = stringResource(id = R.string.forget_password) + " ")
                Text(text = stringResource(id = R.string.forget_password_click_here), color = colorResource(
                    id = R.color.primary)
                )
            }
        }
    }
}