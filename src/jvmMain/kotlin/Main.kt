// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val firstMovie = Movie(title = "Harry Potter", img = "/file", score = 10, year = 2002)

    MaterialTheme {
        Column {
            /*Button(onClick = {
                text = "you clicked"
            }) {
                Text(text)
            }*/

            Text(firstMovie.title)
            Image(
                painter = painterResource("img/img.png"),
                contentDescription = "img",
                modifier = Modifier.size(width = 100.dp, height = 100.dp)
            )
            Text("Score: ${firstMovie.score} - Year: ${firstMovie.year}")
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
