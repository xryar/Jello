package com.example.auth.ui.signin

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.auth.MainActivity
import com.example.auth.state.SignInState
import com.example.ui.components.JelloButtonPrimary
import com.example.ui.components.JelloButtonRow
import com.example.ui.components.JelloEditText
import com.example.ui.components.JelloImageViewClick
import com.example.ui.components.JelloTextHeader
import com.example.ui.components.JelloTextRegular
import com.example.ui.components.JelloTextRegularWithClick
import com.example.ui.components.JelloTextViewRow

@Composable
fun SignInScreen(
    navController: NavController = rememberNavController(),
    viewModel: SignInViewModel = hiltViewModel()
) {

    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val context = LocalContext.current

    viewModel.getToken()
    val token by viewModel.token.observeAsState()
    if (!token.isNullOrEmpty()) {
        viewModel.onNavigateToHome(context)
    }

    val signInState by viewModel.signIn.observeAsState()
    LaunchedEffect(signInState) {
        when (val state = signInState) {
            is SignInState.OnSignInLoading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is SignInState.OnSignInError -> {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
            is SignInState.OnSignInAvailable -> {
                if (state.signInUiModel?.code == 200) {
                    viewModel.onNavigateToHome(context)
                } else {
                    Toast.makeText(context, "Error ${state.signInUiModel?.message}", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {

            }
        }
    }

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
            text = "Welcome to Login",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JelloTextRegularWithClick(
            text = "Please fill E-mail & password to login your app account.",
            textClick = " Sign Up",
            modifier = Modifier.padding(horizontal = 16.dp),
            onClick = {
                navController.navigate(MainActivity.Screen.AuthSignUp.route)
            }
        )

        Spacer(modifier = Modifier.height(25.dp))

        JelloTextRegular(
            text = "E-mail",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        JelloEditText(
            value = email.value,
            onTyping = {
                email.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        JelloTextRegular(
            text = "Password",
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        JelloEditText(
            value = password.value,
            onTyping = {
                password.value = it
            },
            visualTransformation = PasswordVisualTransformation()
        )

        JelloTextViewRow()

        JelloButtonPrimary(
            onClick = {
                if (email.value.isBlank() && password.value.isBlank()) {
                    Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@JelloButtonPrimary
                } else {
                    viewModel.postSignIn(email.value, password.value)
                }
            },
            enabled = email.value.isNotBlank() && password.value.isNotBlank()
        )

        JelloButtonRow()
    }
}

@Preview(
    showBackground = true, device = Devices.NEXUS_5
)
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}