package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.theme.PureOrange

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float,
    starCount: Int = 5,
    onRatingChanged: (Float) -> Unit = {}
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for (i in 1 .. starCount) {
            val icon = if (i <= rating) {
                Icons.Outlined.Star
            } else {
                Icons.Filled.Star
            }
            Icon(
                tint = PureOrange,
                imageVector = icon,
                contentDescription = "rating",
                modifier = Modifier
                    .size(13.dp)
                    .clickable{
                        onRatingChanged(i.toFloat())
                    }
            )
        }
    }
}

@Preview
@Composable
fun RatingBarPreview() {
    RatingBar(
        rating = 3f,
        starCount = 5
    )
}