// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import card.myCard
import extend.getImgBitmap
import java.awt.image.BufferedImage
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

@Composable
@Preview
fun App() {
    val path ="https://sm.ign.com/ign_br/cover/h/harry-pott/harry-potter-the-series_s6p5.jpg"

    MaterialTheme {
        Column {
            myCard(file = path, title = "Harry Potter", score = 10, year = 2002) {}
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}




data class Movie(
    val title: String,
    val img: String,
    val score: Int,
    val year: Int
) {

}
