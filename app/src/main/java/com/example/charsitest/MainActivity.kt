package com.example.charsitest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
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
@Composable
fun MyApp()

{
    Box (modifier = Modifier
        .fillMaxSize()

        , // Zentriert den Inhalt innerhalb des Box-Containers.
        contentAlignment = Alignment.Center
    ){
        // Ruft den aktuellen Kontext ab, der für Toasts verwendet wird.
        var context = LocalContext.current

        // Zustand für den Text im ersten Textfeld.
        var newText by remember {
            mutableStateOf("")
        }
        // Zustand für den Text im zweiten Textfeld.
        var newText2 by remember {
            mutableStateOf("")
        }
        // Controller für die Softwaretastatur.
        var keyboardController = LocalSoftwareKeyboardController.current
        // Manager für den Fokus.
        val focusManager = LocalFocusManager.current
        // Definiert eine vertikale Anordnung von UI-Elementen.
        Column (modifier = Modifier.fillMaxSize()
            ,
            Arrangement.Center, // Zentriert die Elemente vertikal.
            Alignment.CenterHorizontally, // Zentriert die Elemente horizontal.
        )
        {
            // Erstes Textfeld
            TextField(value = newText, onValueChange = {
                nT ->
                newText = nT
            },
                // Gibt den Label-Text an.
                label = { Text(text = "Enter your Email ... ") },
                // Legt die Farben des Textfeldes fest.
                colors = TextFieldDefaults.colors(
                    focusedTextColor = androidx.compose.ui.graphics.Color.Blue,
                    unfocusedTextColor = androidx.compose.ui.graphics.Color.Gray,
                    focusedLabelColor = androidx.compose.ui.graphics.Color.Blue,
                    unfocusedLabelColor = androidx.compose.ui.graphics.Color.Gray,

                ), // maxLines = 6,
                singleLine = true, // Das Textfeld kann nur eine Zeile haben
                modifier = Modifier.width(280.dp), // Setzt die Breite des Textfeldes
                // Platzhalter Text
                placeholder = {
                    Text(text = "abs@gmail.com")
                },
                // Icon am Anfang des Textfeldes
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

                )
            // Abstand zwischen den Elementen
            Spacer(modifier = Modifier.padding(10.dp))
            // Zweites Textfeld
            OutlinedTextField(value = newText2, onValueChange = {
                nT ->
                newText2 = nT
            },
                // Gibt den Label-Text an.
                label = { Text(text = "Enter your Email ... ") },
                // maxLines = 6,
                singleLine = true, // Das Textfeld kann nur eine Zeile haben
                modifier = Modifier.width(280.dp), // Setzt die Breite des Textfeldes
                placeholder = { // Platzhalter Text
                    Text(text = "abs@gmail.com")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Outlined.Email, contentDescription = "Email Icon")
                },
                trailingIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, newText2, Toast.LENGTH_SHORT).show()
                    }) {
                       Icon(imageVector = Icons.Outlined.Send, contentDescription = "send Icon")
                    }
                },
                // Definiert Optionen für die Tastatur
                keyboardOptions = KeyboardOptions(
                    // capitalization = KeyboardCapitalization.Characters
                    capitalization = KeyboardCapitalization.Sentences,// Beginnt jeden Satz mit einem Großbuchstaben.
                    keyboardType = androidx.compose.ui.text.input.KeyboardType.Phone,// Zeigt die Telefontastatur an.
                    imeAction = ImeAction.Send,// Zeigt die "Senden"-Aktion auf der Tastatur an.

                ),
                // Definiert die Aktionen, die beim Drücken der Tasten auf der Tastatur ausgeführt werden.
                keyboardActions = KeyboardActions(
                   onSend = {
                       keyboardController?.hide()// Versteckt die Tastatur.
                       Toast.makeText(context, "send Button clicked", Toast.LENGTH_SHORT).show()// Zeigt einen Toast an.
                       focusManager.clearFocus()// Entfernt den Fokus vom Textfeld.
                   }
                )

                )
            // Abstand zwischen den Elementen
            Spacer(modifier = Modifier.padding(40.dp))
            // Einfaches Textfeld
            BasicTextField(value = newText, onValueChange = {newText = it},
                modifier = Modifier.width(280.dp).height(100.dp).background(Color.Yellow) // Setzt Breite, Höhe und Hintergrundfarbe
                )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApp()
}