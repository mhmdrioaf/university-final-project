package com.gudmal.storagemanagement.ui.components.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.R

@Composable
@ExperimentalComposeUiApi
fun BasicCard(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
    onCardClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clickable { onCardClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.surface)
        )
    ) {
        content()
    }
}