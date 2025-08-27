package com.example.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun JelloTextHeader(
    modifier: Modifier = Modifier.padding(16.dp),
    text: String = "Welcome to Login",
    color: Color = Color.Black,
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Left
        ),
        overflow = TextOverflow.Ellipsis,
        color = color,
        maxLines = 1,
    )
}

@Preview
@Composable
fun JelloTextHeaderPreview() {
    JelloTextHeader(
        text = "Acumalaka xixixxixixii ganteng buanget cik"
    )
}

@Composable
fun JelloTextRegularWithClick() {
    val annotatedText = buildAnnotatedString {
        append("Please fill E-mail & password to login your app account.")

        pushStringAnnotation(
            tag = "TEXT_CLICK",
            annotation = " Sign Up"
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(" Sign Up")
        }
        pop()
    }

    ClickableText(
        text = annotatedText
    ) {

    }
}

@Preview
@Composable
fun JelloTextRegularWithClickPreview() {
    JelloTextRegularWithClick()
}