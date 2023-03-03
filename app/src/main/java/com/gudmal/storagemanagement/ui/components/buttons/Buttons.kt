package com.gudmal.storagemanagement.ui.components.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gudmal.storagemanagement.R
import com.gudmal.storagemanagement.ui.theme.poppinsFamily

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary),
            contentColor = colorResource(id = R.color.onPrimary),
        ),
        modifier = modifier,
        shape = RoundedCornerShape(25.dp)
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontFamily = poppinsFamily
        )
    }
}