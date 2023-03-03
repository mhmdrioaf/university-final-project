package com.gudmal.storagemanagement.ui.screens.dashboard.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.R.string as AppText
import com.gudmal.storagemanagement.R.color as AppColor
import com.gudmal.storagemanagement.R.drawable as AppDrawable
import com.gudmal.storagemanagement.ui.components.buttons.PrimaryButton
import com.gudmal.storagemanagement.ui.components.common.*

@Composable
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
fun DashboardContent(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.Start,
    ) {

        // header
        DashboardHeader(
            profileImage = painterResource(AppDrawable.ic_person),
            profileName = stringResource(AppText.dummy_name),
            onSearchButtonClick = { /*TODO*/ }
        ) {
            // TODO: Implement open drawer onProfileClick
        }

        // profit section
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom

        ) {
            BasicCard(content = {
                // card content container
                Column(
                    modifier = modifier.padding(22.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    // card profit text container
                    Column {
                        BasicText(
                            text = stringResource(AppText.profit),
                            modifier = modifier,
                            fontSize = 22.sp,
                            color = colorResource(AppColor.onSurfaceVariant)
                        )
                        Row {
                            /* TODO: Make function to check if the money thousand or not */
                            BasicText(text = "400,30" + " ", modifier = modifier, fontSize = 28.sp)
                            BasicText(
                                text = stringResource(AppText.money_thousand),
                                modifier = modifier,
                                fontSize = 28.sp,
                                color = colorResource(AppColor.onSurfaceVariant)
                            )
                        }
                    }

                    // card growth container
                    Column {
                        BasicText(
                            text = stringResource(AppText.daily_growth),
                            modifier = modifier,
                            fontSize = 22.sp,
                            color = colorResource(AppColor.onSurfaceVariant)
                        )
                        Row {
                            BasicText(
                                text = stringResource(AppText.percentage) + " ",
                                modifier = modifier,
                                fontSize = 28.sp,
                                color = colorResource(AppColor.onSurfaceVariant)
                            )
                            BasicText(text = "4,6", modifier = modifier, fontSize = 28.sp)
                        }
                    }

                    // chip buttons
                    BasicChipGroup {

                        val chipsData by remember { mutableStateOf(listOf("Weekly", "Monthly")) }
                        var chipState by remember { mutableStateOf("") }

                        chipsData.forEach {
                            BasicChipButton(
                                label = it,
                                selected = it == chipState,
                                onChipChange = { chip ->
                                    chipState = chip
                                }
                            )
                        }

                    }
                }
            }) {
                // onCardClick
                /* TODO: Redirect card click to the revenue report screen */
            }

            // today profit
            Column {
                BasicText(
                    text = stringResource(AppText.today),
                    modifier = modifier,
                    fontSize = 22.sp,
                    color = colorResource(AppColor.onSurfaceVariant)
                )
                Row {
                    /* TODO: Make function to check if the money thousand or not */
                    BasicText(text = "24,43" + " ", modifier = modifier, fontSize = 28.sp)
                    BasicText(
                        text = stringResource(AppText.money_thousand),
                        modifier = modifier,
                        fontSize = 28.sp,
                        color = colorResource(AppColor.onSurfaceVariant)
                    )
                }
            }

        }

        // newest product title
        TitleText(
            title = stringResource(AppText.newest_product),
            subTitle = stringResource(AppText.newest_product_subtitle),
            titleColor = colorResource(AppColor.onSurface),
            subtitleColor = colorResource(AppColor.onSurfaceVariant)
        )

        // product card list
        Column(
            modifier = modifier.fillMaxWidth(),
        ) {
            ProductsCard()

            // show all product button
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                PrimaryButton(
                    text = stringResource(AppText.show_all),
                    modifier = modifier.padding(8.dp)
                ) {
                    // TODO: Redirect to all product screen
                }
            }
        }
    }

    /* TODO: Create bottom navigation */
}