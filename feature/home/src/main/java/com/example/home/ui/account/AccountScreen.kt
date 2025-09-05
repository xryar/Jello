package com.example.home.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.ui.components.JelloImageViewClick
import com.example.ui.components.JelloImageViewPhotoUrlRounded
import com.example.ui.components.JelloTextRegular
import com.example.ui.theme.StrongBlue

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StrongBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            JelloImageViewClick(
                color = Color.White,
                onClick = {

                }
            )
            JelloTextRegular(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = "Profile",
                color = Color.White
            )
            JelloImageViewClick(
                color = Color.White,
                onClick = {

                },
                imageVector = ImageVector.vectorResource(R.drawable.ic_logout)
            )
        }

        Spacer(Modifier.height(30.dp))

        JelloImageViewPhotoUrlRounded(
            url = "https://picsum.photos/200",
            description = "photo profile"
        )

        Spacer(Modifier.height(15.dp))

        JelloTextRegular(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = "Welcom nama user",
            color = Color.White
        )
    }
}

@Composable
fun ItemMenuAccount() {
    Card {
        Row {
            JelloImageViewClick(
                color = Color.White,
                imageVector = Icons.Default.Person
            )
            JelloTextRegular(
                text = "Edit Profile"
            )
            JelloImageViewClick(
                color = Color.White,
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight
            )
        }
    }
}

@Preview
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}
