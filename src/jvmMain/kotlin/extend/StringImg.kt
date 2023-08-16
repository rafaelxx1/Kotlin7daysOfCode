package extend

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import java.awt.image.BufferedImage
import java.net.HttpURLConnection
import java.net.URL
import javax.imageio.ImageIO

fun String.getImgBitmap(): ImageBitmap {
    val url = URL(this) // transform the url string in URL
    val connection = url.openConnection() as HttpURLConnection // make a connection with the URL,
                                                              // and specified as HttpUrlConnection
    connection.doInput = true // make sure that will do the Input
    connection.connect() // make the Connection


    val inputStream = connection.inputStream // it reads the inputstream by the early connection
    val bufferedImg: BufferedImage = ImageIO.read(inputStream) // read the image stream.

    return bufferedImg.toComposeImageBitmap() // transform the bufferedimg to imageBitmap
}