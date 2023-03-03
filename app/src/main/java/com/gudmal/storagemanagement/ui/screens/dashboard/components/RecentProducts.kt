package com.gudmal.storagemanagement.ui.screens.dashboard.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.components.common.*

@Composable
@ExperimentalComposeUiApi
fun ProductCardContent(
    painter: Painter,
    modifier: Modifier = Modifier,
    contentDescription: String?,
    productName: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier
                .fillMaxWidth()
        )
        BasicText(
            text = productName,
            modifier = modifier.padding(vertical = 8.dp),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
    }
}


@Composable
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
fun ProductsCard() {

    // dummies product data
    val productName by remember {
        mutableStateOf(
            listOf(
                "Product 1",
                "Product 2",
                "Product 3"
            )
        )
    }

    val productImage = listOf(
        painterResource(R.drawable.aksesoris),
        painterResource(R.drawable.aksesoris),
        painterResource(R.drawable.aksesoris)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(bottom = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(productName.size) { index ->
                BasicCard(
                    content = {
                    ProductCardContent(
                        painter = productImage[index],
                        contentDescription = null,
                        productName = productName[index]
                    )
                }) {

                }
            }
        }
    )

}