package com.example.charsitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = { }) {
            Text(text = "Simple Button", fontSize = 20.sp)
        }

        OutlinedButton(onClick = { }) {
            Text(text = "Outlined Button", fontSize = 20.sp)
        }

        IconButton( onClick = { }) {
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite",
                modifier = Modifier
                    .padding(10.dp),
                tint = Color.Red
                )
        }

        TextButton( onClick = { }) {
            Text(text = "Text like Button   ", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favorite",
                modifier = Modifier
                    .size(ButtonDefaults.IconSize),
                tint = Color.Red
            )
        }

        Button( onClick = { }) {
            Text(text = "Simple Button", fontSize = 20.sp)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Icon( imageVector = Icons.Filled.Favorite, contentDescription = "Favorite",)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}