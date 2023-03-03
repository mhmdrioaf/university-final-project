package com.gudmal.storagemanagement.ui.screens.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.components.common.BasicText

@Composable
@ExperimentalComposeUiApi
fun DashboardHeader(
    profileImage: Painter,
    profileName: String,
    modifier: Modifier = Modifier,
    onSearchButtonClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    // dashboard header container
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // profile section container
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // profile button
            IconButton(
                onClick = onProfileClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = colorResource(R.color.primaryVariant)
                ),
                modifier = modifier
                    .clip(CircleShape)
                    .size(48.dp)
            ) {
                Image(
                    painter = profileImage,
                    contentDescription = profileName,
                    modifier = modifier
                        .width(48.dp)
                        .height(48.dp)
                        .clip(CircleShape),
                    colorFilter = ColorFilter.tint(colorResource(R.color.onPrimary))
                )
            }
            BasicText(
                text = profileName,
                modifier = modifier,
                fontSize = 14.sp,
                lineHeight = 28.sp,
                color = colorResource(R.color.onPrimary)
            )
        }

        // search button
        IconButton(
            onClick = onSearchButtonClick,
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorResource(R.color.primaryVariant)
            ),
            modifier = modifier
                .clip(CircleShape)
                .size(48.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_search), 
                contentDescription = "search",
                colorFilter = ColorFilter.tint(colorResource(R.color.onPrimary)),
                modifier = modifier.clip(CircleShape).size(24.dp)
            )
        }
    }
}