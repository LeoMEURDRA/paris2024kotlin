package bts.sio.paris2024kotlin.viewmodel.olympiade

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.model.Olympiade
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OlympiadeViewModel : ViewModel() {

    private val _olympiades = MutableStateFlow<List<Olympiade>>(emptyList())
    val olympiades: StateFlow<List<Olympiade>> = _olympiades

    init {
        getAthletes()
    }

    private fun getAthletes() {
        viewModelScope.launch {
            _olympiades.value = listOf(
                Olympiade(1, "XXXIII", 2024, "Paris"),
                Olympiade(2, "XXXII", 2020, "Tokyo"),
                Olympiade(3, "XXXI", 2016, "Rio"),
            )
        }
    }
}