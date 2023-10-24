package com.bumble.puzzyx.imageloader

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.resource

@Composable
expect fun EmbeddableResourceImage(
    path: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit,
)

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun ResourceImage(
    path: String,
    fallbackUrl: String = path,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    var image: ImageBitmap? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        image = withContext(Dispatchers.Default) {
            try {
                resource(path)
                    .readBytes()
                    .toImageBitmap()
            } catch (e: Throwable) {
                try {
                    resource(fallbackUrl)
                        .readBytes()
                        .toImageBitmap()
                } catch (e: Throwable) {
                    null
                }
            }
        }
    }
    image?.let {
        Image(
            bitmap = it,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = contentScale
        )
    }
}
