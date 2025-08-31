package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.theme.LightOrange
import com.example.ui.theme.ModerateBlue
import com.example.ui.theme.PureOrange
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

@Composable
fun JelloButtonFacebook(
    text: String = "Facebook",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth()
        .padding(16.dp)
        .height(56.dp),
) {
    JelloWithIconBaseButton(
        modifier = modifier,
        text = text,
        onClick = onClick,
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = ModerateBlue,
            contentColor = Color.White,
        ),
        srcIcon = R.drawable.ic_facebook,
        descIcon = "Facebook"
    )
}

@Preview
@Composable
fun JelloButtonFacebookPreview() {
    JelloButtonFacebook()
}

@Composable
fun JelloButtonGoogle(
    text: String = "Google",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth()
        .padding(16.dp)
        .height(56.dp),
) {
    JelloWithIconBaseButton(
        modifier = modifier,
        text = text,
        onClick = onClick,
        enabled = true,
        colors = ButtonDefaults.buttonColors(
            containerColor = PureOrange,
            contentColor = Color.White,
        ),
        srcIcon = R.drawable.ic_google,
        descIcon = "Google"
    )
}

@Preview
@Composable
fun JelloButtonGooglePreview() {
    JelloButtonGoogle()
}

@Composable
fun JelloButtonRow(
    onClickGoogle: () -> Unit = {},
    onClickFacebook: () -> Unit = {},
    modifier: Modifier = Modifier.fillMaxWidth()
        .padding(16.dp)
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        JelloButtonGoogle(
            modifier = Modifier
                .height(56.dp)
                .weight(1f),
            onClick = onClickGoogle,
        )
        JelloButtonFacebook(
            modifier = Modifier
                .height(56.dp)
                .weight(1f),
            onClick = onClickFacebook,
        )
    }
}

@Preview
@Composable
fun JelloButtonRowPreview() {
    JelloButtonRow()
}