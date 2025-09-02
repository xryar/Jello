package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ui.theme.VeryLightGray

@Composable
fun JelloImageViewClick(
    modifier: Modifier = Modifier.size(24.dp),
    onClick: () -> Unit = {},
    color: Color = Color.Black,
    imageVector: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    imageDescription: String = "Back",
) {
    IconButton(onClick = { onClick() }) {
        Icon(
            imageVector = imageVector,
            contentDescription = imageDescription,
            modifier = modifier,
            tint = color
        )
    }
}

@Preview
@Composable
fun JelloImageViewClickPreview() {
    JelloImageViewClick()
}

@Composable
fun JelloImageViewPhotoUrlRounded(
    url: String,
    description: String,
) {
    val painter = rememberAsyncImagePainter(
        ImageRequest
            .Builder(LocalContext.current)
            .data(data = url)
            .apply(block = fun ImageRequest.Builder.() {
                crossfade(true)
                    .transformations()
                    .build()
            })
            .build()
    )

    val state = painter.state

    Box(
        contentAlignment = Alignment.Center
    ) {
        if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
            CircularProgressIndicator(
                color = VeryLightGray
            )
        }

        Image(
            painter = painter,
            contentDescription = description,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Preview
@Composable
fun JelloImageViewPhotoUrlRoundedPreview() {
    JelloImageViewPhotoUrlRounded(
        "https://raw.githubusercontent.com/HybridShivam/Pokemon/master/assets/images/254-Mega.png",
        "Pokemon 1"
    )
}