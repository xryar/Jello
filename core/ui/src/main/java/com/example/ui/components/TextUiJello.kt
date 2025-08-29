package com.example.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
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
fun JelloTextRegularWithClick(
    modifier: Modifier = Modifier.padding(16.dp),
    text: String = "Please fill E-mail & password to login your app account.",
    textClick: String = " Sign Up",
    onClick: () -> Unit = {}
) {
    val annotatedText = buildAnnotatedString {
        append(text)

        pushStringAnnotation(
            tag = "TEXT_CLICK",
            annotation = textClick
        )
        withStyle(
            style = SpanStyle(
                color = Color.Blue,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(textClick)
        }
        pop()
    }
    ClickableText(
        modifier = modifier,
        text = annotatedText,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            textAlign = TextAlign.Left,
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(
                tag = "TEXT_CLICK",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                onClick
            }
        }
    )
}

@Preview
@Composable
fun JelloTextRegularWithClickPreview() {
    JelloTextRegularWithClick()
}