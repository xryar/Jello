package com.example.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.auth.ui.signin.SignInScreen
import com.example.auth.ui.signup.SignUpScreen
import com.example.ui.theme.JelloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JelloTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "signin"
                ) {
                    composable("signin") {
                        SignInScreen()
                    }
                    composable("signup") {
                        SignUpScreen()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JelloTheme {
    }
}