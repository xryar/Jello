package com.example.auth.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.components.JelloButtonPrimary
import com.example.ui.components.JelloEditText
import com.example.ui.components.JelloImageViewClick
import com.example.ui.components.JelloTextHeader
import com.example.ui.components.JelloTextRegular
import com.example.ui.components.JelloTextRegularWithClick

@Composable
fun SignUpScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .background(Color.White)
    ) {
        JelloImageViewClick(
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(30.dp))

        JelloTextHeader(
            text = "Create your account",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JelloTextRegularWithClick(
            text = "Do you already have account ?",
            textClick = " Sign In",
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        JelloTextRegular(
            text = "Username",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        JelloEditText(
            value = "Username"
        )

        JelloTextRegular(
            text = "E-mail",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        JelloEditText()

        JelloTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        JelloEditText(
            visualTransformation = PasswordVisualTransformation()
        )

        JelloButtonPrimary(
            text = "Create account"
        )

    }
}

@Preview(
    showBackground = true, device = Devices.NEXUS_5
)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}