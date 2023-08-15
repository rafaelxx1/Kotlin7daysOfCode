// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
    val path =  "hp.png"


    @Composable
    fun myCard(modifier: Modifier = Modifier, file: String, title: String, score: Int, year: Int, content: @Composable () -> Unit) {
        Card(
            modifier = modifier
                .size(width = 300.dp, height = 200.dp)
                .padding(15.dp),
            elevation = 4.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(title)
                Image(
                    painter = painterResource(file),
                    contentDescription = "random",
                    modifier = Modifier.size(width = 100.dp, height = 100.dp)
                )
                Text("Score: $score - Year: $year")
                content()
            }

        }
    }

    MaterialTheme {
        myCard(file = path, title = "Harry Potter", score = 10, year = 2002){}


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
