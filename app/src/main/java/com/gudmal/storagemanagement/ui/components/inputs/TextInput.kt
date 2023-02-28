package com.gudmal.storagemanagement.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R


@Composable
fun EmailInput(value: String, onNewValue: (String) -> Unit, modifier: Modifier = Modifier) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = colorResource(id = R.color.primary),
        backgroundColor = colorResource(id = R.color.primary).copy(alpha = 0.4f)
        )

    val focusManager = LocalFocusManager.current

    Column {
        Text(
            text = stringResource(id = R.string.email_label),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 16.dp),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.primary)
        )

        // change the highlighted text color
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = value,
                onValueChange = { onNewValue(it) },
                modifier = modifier.fillMaxWidth(),
                placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
                keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) }),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.primary),
                    disabledLabelColor = colorResource(id = R.color.onSurfaceVariant),
                    focusedIndicatorColor = colorResource(id = R.color.primary)
                )
            )
        }
    }

}

@Composable
fun PasswordInput(value: String, onNewValue: (String) -> Unit, modifier: Modifier = Modifier) {
    val focusManager = LocalFocusManager.current
    val customTextSelectionColors = TextSelectionColors(
        handleColor = colorResource(id = R.color.primary),
        backgroundColor = colorResource(id = R.color.primary).copy(alpha = 0.4f)
    )

    Column {
        Text(
            text = stringResource(id = R.string.password_label),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 16.dp),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.primary)
        )

        // change the highlighted text color
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = value,
                onValueChange = { onNewValue(it) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
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
}