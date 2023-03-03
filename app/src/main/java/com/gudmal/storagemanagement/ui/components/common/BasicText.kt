package com.gudmal.storagemanagement.ui.components.common

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.theme.poppinsFamily

@Composable
@ExperimentalComposeUiApi
fun BasicText(
    text: String,
    modifier: Modifier,
    fontSize: TextUnit,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = colorResource(R.color.onSurface),
    textAlign: TextAlign = TextAlign.Start,
    lineHeight: TextUnit = LocalTextStyle.current.lineHeight
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        fontFamily = poppinsFamily,
        color = color,
        fontWeight = fontWeight,
        textAlign = textAlign,
        lineHeight = lineHeight
    )
}