package com.gudmal.storagemanagement.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R
import kotlinx.coroutines.job

@Composable
fun EmailField(
    modifier: Modifier = Modifier,
    email: TextFieldValue,
    onEmailValueChange: (newValue: TextFieldValue) -> Unit
) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = colorResource(id = R.color.primary),
        backgroundColor = colorResource(id = R.color.primary).copy(alpha = 0.4f)
    )

    val focusRequester = remember { FocusRequester() }

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
                value = email,
                onValueChange = { newValue ->
                    onEmailValueChange(newValue)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                placeholder = { Text(text = stringResource(R.string.email_placeholder)) },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.primary),
                    disabledLabelColor = colorResource(id = R.color.onSurfaceVariant),
                    focusedIndicatorColor = colorResource(id = R.color.primary)
                )
            )
        }
    }

    LaunchedEffect(Unit) {
        coroutineContext.job.invokeOnCompletion {
            focusRequester.requestFocus()
        }
    }

}