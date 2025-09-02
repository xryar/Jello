package com.example.home.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.R
import com.example.ui.components.BannerSliderUiJello
import com.example.ui.components.JelloImageViewClick
import com.example.ui.components.JelloImageViewPhotoUrlRounded
import com.example.ui.components.JelloTextRegular
import com.example.ui.theme.LightGrayishBlue
import com.example.ui.theme.StrongBlue
import com.example.ui.theme.VividMagenta

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(StrongBlue)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clickable{

                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    JelloImageViewClick(
                        color = Color.White,
                        imageVector = Icons.Outlined.Search,
                        onClick = {

                        }
                    )

                    JelloTextRegular(
                        text = "Cari barang kamu disini",
                        color = Color.White,
                    )
                }
            }
            JelloImageViewClick(
                color = Color.White,
                imageVector = Icons.Outlined.ShoppingCart,
                onClick = {

                }
            )
        }

        val images = listOf(
            painterResource(R.drawable.sample_slide1),
            painterResource(R.drawable.sample_slide1),
            painterResource(R.drawable.sample_slide1),
        )
        BannerSliderUiJello(
            bannerImage = images,
            onClick = {

            }
        )

        val temp = listOf(
            ProductItem(
                "CATEGORIES",
                listOf(
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                )
            ),
            ProductItem(
                "NEW PRODUCT",
                listOf(
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                    "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
                )
            )
        )
        ItemProductHomeList(temp)
    }
}

@Preview(showBackground = true, device = Devices.NEXUS_5)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

data class ProductItem(
    val title: String,
    val subItems: List<String> = emptyList()
)

@Composable
fun ItemProductHomeList(items: List<ProductItem>) {
    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(Color.White)
            .fillMaxSize()
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                JelloTextRegular(
                    modifier = Modifier.padding(16.dp),
                    text = item.title,
                    color = Color.Black
                )

                val annotatedString = buildAnnotatedString {
                    withStyle(
                        SpanStyle(color = VividMagenta)
                    ) {
                        append("SEE ALL")
                    }
                }

                ClickableText(
                    text = annotatedString,
                    onClick = {

                    }
                )
            }

            if (item.subItems.isNotEmpty()) {
                SubItemList(item.subItems)
            }
        }
    }
}

@Composable
fun SubItemList(subItems: List<String>) {
    LazyRow(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        items(subItems) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp, bottom = 16.dp)
                    .clickable{

                    },
                colors = CardDefaults.cardColors(
                    containerColor = LightGrayishBlue
                )
            ) {
                JelloImageViewPhotoUrlRounded(
                    item,
                    "image ke $item"
                )
            }
        }
    }
}