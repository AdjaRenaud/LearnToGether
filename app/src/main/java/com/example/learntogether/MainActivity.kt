package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
//                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        stringResource(R.string.title),
                        stringResource(R.string.introduction),
                        stringResource(R.string.development)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, intro: String, develo: String, modifier: Modifier=Modifier) {
    Column (
//        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()

    ){
        Text(
            text = message,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp),

        )
        Text(
            text = intro,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
            ),
            textAlign = TextAlign.Justify
        )
        Text(
            text = develo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }

}

@Composable
fun GreetingImage(message: String, intro: String, develo: String, modifier: Modifier=Modifier){
val image = painterResource(R.drawable.bg_compose_background)
    Column  {
        Image(
            painter = image,
            contentDescription = null,
//            contentScale = ContentScale.Crop
        )
        GreetingText(
            message= message,
            intro = intro,
            develo = develo,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(0.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LearnCardPreview() {
    LearnTogetherTheme {
        GreetingImage(
            "Jetpack Compose tutorial!",
            "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name.")
    }
}