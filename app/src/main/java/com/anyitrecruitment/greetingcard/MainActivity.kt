package com.anyitrecruitment.greetingcard

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anyitrecruitment.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ChristmasGreetingWithImage(message = stringResource(R.string.merry_christmas), " - from Jonathan")
                }
            }
        }
    }
}

@Composable
fun ChristmasGreetingWithImage(message: String, from: String){
    val image = painterResource(id = R.drawable.androidparty)
    Box{
        Image(painter = image, contentDescription = null, modifier = Modifier.fillMaxHeight().fillMaxWidth(), contentScale = ContentScale.Crop)
        ChristmasGreeting(message = message, from = from)
    }
}

@Composable
fun ChristmasGreeting(message: String, from: String){
    Column{
        Text(text = message, fontSize = 36.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.Start).padding(start = 16.dp, top = 16.dp))
        Text(text = from, fontSize = 24.sp, modifier = Modifier.fillMaxWidth().wrapContentWidth(align = Alignment.End).padding(start = 16.dp, end = 16.dp))
    }
}


@Preview(showBackground = false)
@Composable
fun ChristmasGreetingWithImagePreview() {
    GreetingCardTheme {
        ChristmasGreetingWithImage(message = stringResource(R.string.merry_christmas), " - from Jonathan")
    }
}