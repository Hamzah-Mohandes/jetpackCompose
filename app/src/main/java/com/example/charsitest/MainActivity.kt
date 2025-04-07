package com.example.charsitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
        MyApp()
        }
    }
}

@Composable
fun MyApp() {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(
            text = "Hello",
            color = Color.White, // Sets the font color to white
            fontSize = 52.sp,
            modifier = Modifier
                 .padding(16.dp) // das ist margin
                .background(Color.Black)
                .padding(16.dp)

                //.padding(16.dp)
//                .width(200.dp)
//                .height(100.dp)
//                .size(200.dp)
//                .fillMaxWidth(1f)
//                .fillMaxSize(0.6F)
//                .fillMaxHeight()
        )
        Box (modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .rotate(45f) // Rotates the box by 45 degrees
            .alpha(0.5f) // Sets the opacity to 50%
            .background(Color.Red)


        ) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()

}