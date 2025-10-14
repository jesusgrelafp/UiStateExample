package com.example.uistatesample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.uistatesample.model.EjemploUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class EjemploAppViewModel : ViewModel() {

    /*---------------------------------------------------------------
     Patrón "State encapsulation pattern"
     Ventajas:
      1.- Encapsulación: El exterior solo puede leer, no modificar
      2.- Seguridad: Previene modificaciones accidentales
      3.- Reactividad: Los cambios se notifican automáticamente
    ---------------------------------------------------------------*/

    /*---------------------------------------------------------------
       MutableStateFlow es una clase de Kotlin Flow que mantiene un valor actual y
       emite actualizaciones cada vez que cambia.
       Es mutable: puede cambiar su valor internamente con _uiState.value = nuevoValor
       Se crea un flujo con un estado inicial de tipo EjemploUiState
       Por tanto, _uiState guarda el estado actual de la pantalla y puede actualizarse dentro del ViewModel
     ---------------------------------------------------------------*/
    private val _uiState = MutableStateFlow(EjemploUiState())

    /*---------------------------------------------------------------
       Se expone una versión inmutable del flujo hacia el exterior (por ejemplo, a la UI).
       StateFlow<EjemploUiState> --> Tipo de solo lectura
       asStateFlow() --> convierte el MutableStateFlow en un StateFlow, que solo permite leer, no modificar el valor.
       Esto es un patrón muy usado para encapsular el estado:
           1.- El ViewModel puede modificar _uiState
           2.- La UI (Composable) solo puede observar uiState
    ---------------------------------------------------------------*/
    val uiState : StateFlow<EjemploUiState> = _uiState.asStateFlow()

    /*---------------------------------------------------------------

    - Lee el valor actual _uiState.value.
    - Llama a copy(...) de la data class para crear un nuevo objeto EjemploUiState
      tomando todas las propiedades actuales excepto contador, que se actualiza a contador + 1.
    - Asigna ese nuevo objeto a _uiState.value. Al asignar, MutableStateFlow emite el nuevo valor
      a todos los coleccionistas - collectAsState() -, provocando recomposición donde corresponda.
    - EjemploUiState: no se mutan sus campos, se crea un nuevo objeto con los cambios mediante copy().

    ---------------------------------------------------------------*/
    fun incrementar() {
        _uiState.value = _uiState.value.copy(
            contador = _uiState.value.contador + 1
        )
    }

    /*---------------------------------------------------------------

    Kotlin Flow ofrece la extensión update que hace la actualización de forma segura
     (internamente realiza un compare-and-set repetido hasta que tiene éxito)
     Ventajas:
      - Atómica: evita pérdidas en actualizaciones concurrentes.
      - Código más claro y evita lecturas repetidas de _uiState.value

    ---------------------------------------------------------------*/
    fun incrementarWithUpdate() {
        _uiState.update { current ->
            current.copy(contador = current.contador + 1)
        }
    }

    fun cambiarEstadoSwitch() {
        _uiState.value = _uiState.value.copy(
            estadoSwitch = !_uiState.value.estadoSwitch
        )
    }

    fun cambiarEstadoSwitchWithUpdate() {
        _uiState.update { currentState ->
            currentState.copy(
                estadoSwitch = !currentState.estadoSwitch
            )
        }
    }
}
