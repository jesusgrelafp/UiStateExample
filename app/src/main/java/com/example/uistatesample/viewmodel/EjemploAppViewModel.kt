package com.example.uistatesample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uistatesample.model.EjemploUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EjemploAppViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(EjemploUiState())
    val uiState : StateFlow<EjemploUiState> = _uiState.asStateFlow()
    fun sumaUno() {
        _uiState.update { estadoActual ->
            estadoActual.copy(contador = estadoActual.contador + 1)
        }
    }
    fun cambiarEstadoSwitch() {
        _uiState.update { estadoActual ->
            estadoActual.copy(estadoSwitch = !estadoActual.estadoSwitch)
        }
    }

}