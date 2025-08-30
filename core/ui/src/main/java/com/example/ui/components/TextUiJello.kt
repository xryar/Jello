package com.example.ui.components

import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.VividMagenta

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
                color = VividMagenta,
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

@Composable
fun JelloTextRegular(
    modifier: Modifier = Modifier.padding(16.dp),
    text: String = "E-mail",
    color: Color = Color.Black
) {
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            textAlign = TextAlign.Left
        ),
        color = color
    )
}

@Preview
@Composable
fun JelloTextRegularPreview() {
    JelloTextRegular()
}

@Composable
fun JelloTextViewRow(
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {},
    onTextClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        JelloCheckBox(
            checked = checked,
            onCheckedChange = onCheckedChange,
        )

        val annotatedString = buildAnnotatedString {
            append("Forgot password ?")
        }

        ClickableText(
            text = annotatedString,
            onClick = {
                onTextClick
            }
        )
    }
}

@Preview
@Composable
fun JelloTextViewRowPreview() {
    JelloTextViewRow()
}