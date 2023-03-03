package com.gudmal.storagemanagement.ui.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.screens.dashboard.components.DashboardContent

@Composable
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
fun DashboardScreen() {

    /* TODO: Create dashboard screen based on design. */

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.dashboard_page_background),
                contentScale = ContentScale.FillBounds
            ),
    ) {
        DashboardContent()
    }
}