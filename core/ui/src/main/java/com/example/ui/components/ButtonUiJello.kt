package com.example.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.LightOrange
import com.example.ui.theme.VeryDarkGrayishBlue

@Composable
fun JelloButtonPrimary(
    text: String = "Login Now",
    onClick: () -> Unit = {},
) {
    JelloBaseButton(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .height(56.dp),
        text = text,
        onClick = onClick,
        enabled = true,
        color = ButtonDefaults.buttonColors(
            containerColor = LightOrange,
            contentColor = VeryDarkGrayishBlue,
        )
    )
}

@Preview
@Composable
fun JelloButtonPrimaryPreview() {
    JelloButtonPrimary()
}