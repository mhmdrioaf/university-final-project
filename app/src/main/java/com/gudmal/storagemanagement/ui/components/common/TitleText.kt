package com.gudmal.storagemanagement.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.R

@Composable
@ExperimentalComposeUiApi
fun TitleText(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    titleColor: Color = colorResource(R.color.onPrimary),
    subtitleColor: Color = colorResource(R.color.onPrimaryVariant)
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
    ) {
        BasicText(
            text = title,
            modifier = modifier,
            fontSize = 32.sp,
            color = titleColor
        )
        BasicText(
            text = subTitle,
            modifier = modifier,
            fontSize = 16.sp,
            color = subtitleColor
        )
    }
}