package ru.isu.auc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.isu.auc.common.LoadingView
import ru.isu.auc.ui.theme.AuctionTrainerClientTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuctionTrainerClientTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoadingView()
                }
            }
        }
    }
}

@Preview(widthDp = 320, heightDp = 300)
@Composable
fun LazyColumnSample() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        items(100) { position ->

            println("Build item at position $position")

            Row (modifier = Modifier.clickable(onClick = {println("click $position")})){
                MyListItem(
                    position = position,
                    color = Color.Gray,
                )
            }

            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Preview(widthDp = 320, heightDp = 50)
@Composable
fun MyListItem(
    position: Int = 0,
    color: Color = Color.Gray,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.9f)
            .padding(4.dp)
            .height(42.dp)
    ) {
        Box(
            modifier = Modifier
                .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                .clip(CircleShape)
                .background(color)
        ) {
            Text(
                text = position.toString(),
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.width(6.dp))

        Column(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(12.dp)
                    .clip(shape = RoundedCornerShape(2.dp))
                    .background(color)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.6f)
                    .height(8.dp)
                    .clip(shape = RoundedCornerShape(2.dp))
                    .background(color)
            )
        }
    }
}