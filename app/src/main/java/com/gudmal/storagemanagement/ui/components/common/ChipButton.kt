package com.gudmal.storagemanagement.ui.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.gudmal.storagemanagement.ui.theme.poppinsFamily
import com.gudmal.storagemanagement.R.color as AppColor

@Composable
@ExperimentalMaterial3Api
fun BasicChipButton(
    label: String,
    selected: Boolean,
    onChipChange: (String) -> Unit
) {
    SuggestionChip(
        label = {
            Text(
                text = label,
                fontFamily = poppinsFamily,
                color =  colorResource(id = if (selected) AppColor.onPrimary else AppColor.onPrimaryVariant))
        },
        onClick = {
                  if (!selected)
                      onChipChange(label)
                  else
                      onChipChange("")
        },
        shape = RoundedCornerShape(16.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (selected) colorResource(AppColor.primary) else colorResource(AppColor.primaryVariant)
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = Color.Transparent
        )
    )
}

@Composable
@ExperimentalMaterial3Api
fun BasicChipGroup(
    content: @Composable () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}
