package com.gudmal.storagemanagement.ui.screens.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.gudmal.storagemanagement.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.ui.components.buttons.PrimaryButton
import com.gudmal.storagemanagement.ui.components.inputs.EmailInput
import com.gudmal.storagemanagement.ui.components.inputs.PasswordInput

@Composable
fun TitleText(text: String, modifier: Modifier) {
    Text(text = text, modifier = modifier, fontSize = 34.sp)
}

@Composable
fun MainLoginScreen(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // login screen title
        TitleText(
            text = stringResource(id = R.string.login_title),
            modifier = modifier.align(CenterHorizontally)
        )

        // text input sections
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = CenterHorizontally

        ) {
            EmailInput(
                modifier
                    .align(CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            )
            PasswordInput(
                modifier
                    .align(CenterHorizontally)
                    .fillMaxWidth()
            )
        }

        // button
        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = CenterHorizontally
        ) {
            PrimaryButton(
                text = stringResource(id = R.string.login_button_text),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp),
            ) {
                /* TODO: Implement the firebase authentication */
            }
            Row {
                Text(text = stringResource(id = R.string.forget_password) + " ")
                Text(text = stringResource(id = R.string.forget_password_click_here), color = colorResource(
                    id = R.color.primary))
            }
        }
    }
}