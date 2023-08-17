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


    val inputStream = connection.inputStream // it reads the input stream by the early connection
    val bufferedImg: BufferedImage = ImageIO.read(inputStream) // read the image stream.

    val scaledImg = bufferedImg.getScaledInstance(766, 766, BufferedImage.SCALE_SMOOTH) // putting a width and height to the img
    val newBufferedImg = BufferedImage(766, 766, BufferedImage.TYPE_INT_ARGB) // create a new buffer with the new dimension

    val g = newBufferedImg.createGraphics()
    g.drawImage(scaledImg, 0, 0, null)
    g.dispose() // draw the img

    return newBufferedImg.toComposeImageBitmap() // transform the buffered img to an imageBitmap
}