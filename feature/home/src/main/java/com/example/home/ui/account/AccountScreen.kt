package com.example.home.ui.account

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            text = "Welcome nama user",
            color = Color.White
        )

        Spacer(Modifier.height(64.dp))
        Spacer(Modifier.weight(1f))

        val sampleMenu = listOf(
            MenuItem(
                iconLeft = Icons.Default.Person,
                label = "Edit Profile",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
            MenuItem(
                iconLeft = Icons.Default.Place,
                label = "Shipping Address",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
            MenuItem(
                iconLeft = Icons.Default.Favorite,
                label = "Wishlist",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
            MenuItem(
                iconLeft = ImageVector.vectorResource(R.drawable.ic_history),
                label = "Order History",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
            MenuItem(
                iconLeft = Icons.Default.Notifications,
                label = "Notification",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
            MenuItem(
                iconLeft = ImageVector.vectorResource(R.drawable.ic_cards),
                label = "Cards",
                iconRight = Icons.AutoMirrored.Filled.KeyboardArrowRight
            ),
        )

        LazyColumn(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp, 20.dp))
                .background(Color.White)
        ) {
            items(sampleMenu) {
                ItemMenuAccount(
                    iconLeft = it.iconLeft,
                    label = it.label,
                )
            }
        }
    }
}

data class MenuItem(
    val iconLeft: ImageVector,
    val label: String,
    val iconRight: ImageVector,
)

@Composable
fun ItemMenuAccount(
    modifier: Modifier = Modifier,
    label: String = "Edit Profile",
    iconLeft: ImageVector = Icons.Default.Person,
    iconRight: ImageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
    colorLeft: Color = Color.Black,
    colorRight: Color = Color.Black,
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .clickable{

            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            JelloImageViewClick(
                color = colorLeft,
                imageVector = iconLeft,
                imageDescription = "Icon Left"
            )
            JelloTextRegular(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .weight(1f),
                text = label
            )
            JelloImageViewClick(
                color = colorRight,
                imageVector = iconRight,
                imageDescription = "Icon Right"
            )
        }
    }
}

@Preview
@Composable
fun AccountScreenPreview() {
    AccountScreen()
}
