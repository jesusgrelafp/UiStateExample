package com.example.uistatesample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.uistatesample.model.EjemploUiState

@Composable
fun ComponenteB(modifier: Modifier = Modifier,
                uiState: EjemploUiState
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = "Contador: ${uiState.contador}", fontSize = 36.sp)
    }
}
