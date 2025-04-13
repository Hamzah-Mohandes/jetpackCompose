package com.example.charsitest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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
fun MyApp()

{
    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

        var newText by remember {
            mutableStateOf("")
        }

        Column (modifier = Modifier.fillMaxSize()
            .padding(25.dp)
        )
        {
            TextField(value = newText, onValueChange = {
                nT ->
                newText = nT
            },
                label = { Text(text = "Enter your Email ... ") },
                maxLines = 6

                )}
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}