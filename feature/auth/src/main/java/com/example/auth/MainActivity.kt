package com.example.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth.ui.signin.SignInScreen
import com.example.auth.ui.signin.SignInViewModel
import com.example.auth.ui.signup.SignUpScreen
import com.example.ui.theme.JelloTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val signInViewModel : SignInViewModel by viewModels()

    sealed class Screen(val route: String) {
        object AuthSignIn: Screen("auth/signin")
        object AuthSignUp: Screen("auth/signup")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JelloTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.AuthSignIn.route
                ) {
                    composable(Screen.AuthSignIn.route) {
                        SignInScreen(
                            navController = navController,
                            viewModel = signInViewModel
                        )
                    }
                    composable(Screen.AuthSignUp.route) {
                        SignUpScreen(navController)
                    }
                }
            }
        }
    }
}