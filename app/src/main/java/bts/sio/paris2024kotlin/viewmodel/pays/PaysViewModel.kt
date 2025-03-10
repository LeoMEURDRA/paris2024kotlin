package bts.sio.paris2024kotlin.viewmodel.pays

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.model.Pays
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaysViewModel : ViewModel() {

    private val _pays = MutableStateFlow<List<Pays>>(emptyList())
    val pays: StateFlow<List<Pays>> = _pays

    init {
        getSites()
    }

    private fun getSites() {
        viewModelScope.launch {
            _pays.value = listOf(
                Pays(1, "France"),
                Pays(2, "Allemagne"),
                Pays(3, "Vietnam")
            )
        }
    }
}