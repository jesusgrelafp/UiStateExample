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
    fun incrementar() {
        _uiState.value = _uiState.value.copy(
            contador = _uiState.value.contador + 1
        )
    }
    fun cambiarEstadoSwitch() {
        _uiState.value = _uiState.value.copy(
            estadoSwitch = !_uiState.value.estadoSwitch
        )
    }
}