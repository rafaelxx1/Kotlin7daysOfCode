package card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import extend.getImgBitmap
import java.awt.Color.white
import java.awt.Color.yellow

@Composable
fun myCard(
    modifier: Modifier = Modifier,
    file: String,
    title: String,
    score: Int,
    year: Int,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(width = 200.dp, height = 250.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(3.dp)),
        elevation = 10.dp
    ) {
        Card(
            modifier = Modifier
                .border(border = BorderStroke(5.dp, color = Color.DarkGray))
                .padding(10.dp),
            elevation = 5.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                //verticalArrangement = Arrangement.Center
            ) {
                Image(
                    alignment = Alignment.TopEnd,
                    bitmap = file.getImgBitmap(),
                    contentDescription = "random",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth(),
                )
                Row(
                    modifier = Modifier
                        .padding(top = 6.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        Icons.Rounded.Star,
                        tint = Color.Yellow,
                        contentDescription = "star",
                        modifier = Modifier
                            .size(22.dp)
                            .padding(start = 10.dp)
                    )
                    Text(
                        text = "$score",
                        modifier = Modifier
                            .weight(1f)
                            .size(25.dp)
                    )
                    Text(
                        text = "$year",
                        modifier = Modifier
                            .padding(end = 10.dp)
                    )
                }
                Text(text = title, modifier = Modifier.align(Alignment.CenterHorizontally))
                //Text("Score: $score - Year: $year")
                content()
            }

        }
    }
}
