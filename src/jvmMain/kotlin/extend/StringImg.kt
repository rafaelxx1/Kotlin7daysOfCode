package extend

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import java.awt.image.BufferedImage
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

fun String.getImgBitmap(): ImageBitmap {
    val url = URL(this)
    val connection = url.openConnection() as HttpURLConnection
    connection.doInput = true
    connection.connect()


    val inputStream = connection.inputStream
    val bufferedImg: BufferedImage = ImageIO.read(inputStream)

    return bufferedImg.toComposeImageBitmap()
}