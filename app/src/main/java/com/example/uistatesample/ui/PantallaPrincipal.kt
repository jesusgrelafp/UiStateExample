package com.example.uistatesample.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uistatesample.viewmodel.EjemploAppViewModel
import com.example.uistatesample.ui.components.*

@Preview (showBackground = true)
@Composable
fun PantallaPrincipal (modifier : Modifier = Modifier,
                       viewModel: EjemploAppViewModel = viewModel()
) {
    /*---------------------------------------------------
    Escucha el estado del uiState y redibuja la UI cuando cambia
      - viewModel.uiState  esto accede al StateFlow que el ViewModel expone
      - .collectAsState()   conecta tu flujo (Flow/StateFlow) con el
        sistema reactivo de Compose. Cada vez que el StateFlow emite un nuevo valor,
        Compose recompone automáticamente los elementos que usan ese valor.
      - val uiState by   el operador by (delegación de propiedades).
        Evita que tengamos que referencia con uiState.value.
    -----------------------------------------------------*/
    val uiState by viewModel.uiState.collectAsState()
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxHeight()
    ) {
        ComponenteA(estadoSwitch = uiState.estadoSwitch,
                    onIncrementar = { viewModel.incrementar() },
                    onSwitchChange = { viewModel.cambiarEstadoSwitch() },
                    modifier = modifier.height(80.dp))
        Spacer(modifier.height(80.dp))
        ComponenteB(contador = uiState.contador,
                    modifier = modifier.height(80.dp))
        ComponenteC(estadoSwitch = uiState.estadoSwitch,
                    modifier = modifier.height(80.dp))
    }
}