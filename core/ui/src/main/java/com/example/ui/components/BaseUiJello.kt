package com.example.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JelloBaseButton(
    modifier: Modifier = Modifier,
    text:String = "Default Text",
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(8.dp),
    color: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color.Blue,
        contentColor = Color.White,
    )
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = color,
        onClick = { onClick }
    ) {
        Text(text)
    }
}

@Preview
@Composable
fun JelloBaseButtonPreview() {
    JelloBaseButton()
}

@Composable
fun JelloWithIconBaseButton() {
    Button(
        onClick = {}
    ) {
        Text("Login Now")
    }
}

@Preview
@Composable
fun JelloWithIconBaseButtonPreview() {
    JelloWithIconBaseButton()
}