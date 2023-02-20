package com.gudmal.storagemanagement.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R

@Composable
fun EmailInput(modifier: Modifier) {

    var email by remember { mutableStateOf("") }

    Column {
        Text(
            text = stringResource(id = R.string.email_label),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 16.dp),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.primary)
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = modifier.fillMaxWidth(),
            placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.primary),
                disabledLabelColor = colorResource(id = R.color.onSurfaceVariant),
                focusedIndicatorColor = colorResource(id = R.color.primary)
            )
        )
    }

}

@Composable
fun PasswordInput(modifier: Modifier) {
    var password by rememberSaveable { mutableStateOf("") }

    Column {
        Text(
            text = stringResource(id = R.string.password_label),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 16.dp),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.primary)
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = stringResource(id = R.string.password_placeholder)) },
            modifier = modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.primary),
                disabledLabelColor = colorResource(id = R.color.onSurfaceVariant),
                focusedIndicatorColor = colorResource(id = R.color.primary)
            )
        )
    }
}