package com.example.home.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.components.JelloImageViewClick
import com.example.ui.components.JelloTextRegular

@Composable
fun HomeScreen() {
    Column {
        Row {
            Card {
                Row {
                    JelloImageViewClick()
                    JelloTextRegular()
                }
            }
            JelloImageViewClick()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}