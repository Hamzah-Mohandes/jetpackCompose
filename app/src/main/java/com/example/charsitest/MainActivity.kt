package com.example.charsitest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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

        var context = LocalContext.current
        var newText by remember {
            mutableStateOf("")
        }

        Column (modifier = Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally,
        )
        {
            TextField(value = newText, onValueChange = {
                nT ->
                newText = nT
            },
                label = { Text(text = "Enter your Email ... ") },
               // maxLines = 6,
                singleLine = true,
                modifier = Modifier.width(280.dp),
                placeholder = {
                    Text(text = "abs@gmail.com")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email Icon")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newText, Toast.LENGTH_SHORT).show()
                    }) {
                       Icon(imageVector = Icons.Outlined.Send, contentDescription = "send Icon")
                    }
                }

                )}
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}