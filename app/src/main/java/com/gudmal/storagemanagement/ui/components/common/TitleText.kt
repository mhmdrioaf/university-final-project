package com.gudmal.storagemanagement.ui.components.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.ui.theme.poppinsFamily

@Composable
@ExperimentalComposeUiApi
fun TitleText(text: String, modifier: Modifier) {
    Text(text = text, modifier = modifier, fontSize = 34.sp, fontFamily = poppinsFamily)
}