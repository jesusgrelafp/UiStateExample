package com.example.uistatesample.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.uistatesample.viewmodel.EjemploAppViewModel
import com.example.uistatesample.model.EjemploUiState

@Composable
fun ComponenteA(modifier: Modifier = Modifier,
                uiState: EjemploUiState,
                viewModel: EjemploAppViewModel
) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier.fillMaxWidth()
        ) {
            Button(onClick = { viewModel.sumaUno() }) {
                Text(text = "Suma +1", fontSize = 24.sp)
            }
            Switch(
                checked = uiState.estadoSwitch,
                onCheckedChange = { viewModel.cambiarEstadoSwitch() }
            )
        }
}
