package com.example.charsitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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

/**
 * Haupt-Composable-Funktion, die das UI der App definiert.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyTextField()
    }
}

/**
 * @Preview-Funktion zur Vorschau der UI.
 */
@Composable
fun MyTextField() {
    var textState by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    TextField(
        value = textState,
        onValueChange = {
            textState = it
            isError = it.length < 3
        },
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(0.8f)
            .clip(RoundedCornerShape(12.dp))
            .shadow(4.dp, RoundedCornerShape(12.dp)),
        label = { Text(text = "Dein Name") },
        placeholder = { Text(text = "Gib deinen Namen ein") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "User",
                tint = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
            )
        },
        isError = isError,
        supportingText = { if (isError) Text("Name muss mindestens 3 Zeichen haben") },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Words,
            keyboardType = KeyboardType.Text
        ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedLabelColor = MaterialTheme.colorScheme.primary,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurface,
            focusedLeadingIconColor = MaterialTheme.colorScheme.primary,
            unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurface,
            errorIndicatorColor = MaterialTheme.colorScheme.error,
            errorLabelColor = MaterialTheme.colorScheme.error,
            errorSupportingTextColor = MaterialTheme.colorScheme.error
        )
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}
