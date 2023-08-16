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


    MaterialTheme {
        Row {
            movielist.forEach{movie ->
                myCard(file = movie.url, title = movie.title, score = movie.score, year = movie.year) {}
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}


// just for test, isn't the final structure
val url ="https://sm.ign.com/ign_br/cover/h/harry-pott/harry-potter-the-series_s6p5.jpg"
val url2 = "https://s2.glbimg.com/Ts4sEmZsMfd-v5gDh4ev5IxXOZU=/e.glbimg.com/og/ed/f/original/2022/02/22/fmnz6aexiau47m8.jpg"
val url3 = "https://m.media-amazon.com/images/M/MV5BMTU5MDg0NTQ1N15BMl5BanBnXkFtZTcwMjA4Mjg3Mg@@._V1_FMjpg_UX1000_.jpg"

val movie1 = Movie("Harry Potter", url, 10, 2001 )
val movie2 = Movie("Fantastic Beasts", url2, 10, 2017)
val movie3 = Movie("Zombieland",url3, 10, 2010)
val movielist: List<Movie> = listOf(movie1,movie2, movie3)


data class Movie(
    val title: String,
    val url: String,
    val score: Int,
    val year: Int
) {

}
