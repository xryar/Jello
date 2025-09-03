package com.example.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AccountScreen() {
    ScreenContent("Account")
}

@Composable
fun ScreenContent(title:String) {
    Column {
        Text(title)
    }
}