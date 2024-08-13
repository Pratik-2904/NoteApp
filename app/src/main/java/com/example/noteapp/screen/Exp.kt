package com.example.noteapp.screen

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Exp(){
    Surface(
        modifier = Modifier.size(40.dp),
        color = Color.Green
    ) {
        Text(text = "Hello There")
    }
}