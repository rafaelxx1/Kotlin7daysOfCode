package card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import extend.getImgBitmap

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
                bitmap = file.getImgBitmap(),
                contentDescription = "random",
                modifier = Modifier.size(width = 100.dp, height = 100.dp)
            )
            Text("Score: $score - Year: $year")
            content()
        }

    }
}
