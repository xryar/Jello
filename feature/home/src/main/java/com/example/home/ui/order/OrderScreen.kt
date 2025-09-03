package com.example.home.ui.order

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.example.ui.components.JelloTextRegular
import com.example.ui.theme.Gray
import com.example.ui.theme.LightGrayishBlue
import com.example.ui.theme.VeryLightGray

@Composable
fun OrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
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
                    containerColor = Gray.copy(alpha = 0.1f)
                )
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    JelloTextRegular(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                            .weight(1f),
                        text = "Cari barang kamu disini",
                        color = Gray
                    )
                    JelloImageViewClick(
                        color = Gray,
                        onClick = {

                        },
                        imageVector = Icons.Outlined.Search
                    )
                }
            }
        }

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 2.dp,
            color = VeryLightGray
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            JelloTextRegular(
                text = "NEW PRODUCT",
                modifier = Modifier.weight(1f)
            )

            JelloImageViewClick(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter),
                color = LightGrayishBlue
            )
            JelloImageViewClick(
                imageVector = ImageVector.vectorResource(R.drawable.ic_catalog_more),
                color = LightGrayishBlue
            )
        }
    }
}

@Preview
@Composable
fun OrderScreenPreview() {
    OrderScreen()
}