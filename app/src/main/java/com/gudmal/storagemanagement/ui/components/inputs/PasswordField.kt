package com.gudmal.storagemanagement.ui.components.inputs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.theme.poppinsFamily

@Composable
@ExperimentalMaterial3Api
fun PasswordField(
    modifier: Modifier,
    password: TextFieldValue,
    onPasswordValueChange: (newValue: TextFieldValue) -> Unit
) {

    val customTextSelectionColors = TextSelectionColors(
        handleColor = colorResource(id = R.color.primary),
        backgroundColor = colorResource(id = R.color.primary).copy(alpha = 0.4f)
    )

    var passwordIsVisible by remember { mutableStateOf(false) }

    Column {
        Text(
            text = stringResource(id = R.string.password_label),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp, start = 16.dp),
            textAlign = TextAlign.Start,
            color = colorResource(id = R.color.primary),
            fontFamily = poppinsFamily,
        )

        // change the highlighted text color
        CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
            TextField(
                value = password,
                onValueChange = { newValue ->
                    onPasswordValueChange(newValue)
                },
                textStyle = TextStyle.Default.copy(fontFamily = poppinsFamily),
                visualTransformation = if (passwordIsVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                               val icon = if (passwordIsVisible) {
                                   painterResource(R.drawable.icon_visibility)
                               } else {
                                   painterResource(R.drawable.icon_visibility_off)
                               }
                    IconButton(
                        onClick = {
                            passwordIsVisible = !passwordIsVisible
                        }
                    ) {
                        Icon(
                            painter = icon,
                            contentDescription = "password visibility icon"
                        )
                    }
                },
                placeholder = { Text(text = stringResource(id = R.string.password_placeholder), fontFamily = poppinsFamily) },
                singleLine = true,
                modifier = modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    cursorColor = colorResource(id = R.color.primary),
                    disabledLabelColor = colorResource(id = R.color.onSurfaceVariant),
                    focusedIndicatorColor = colorResource(id = R.color.primary),
                )
            )
        }
    }
}