package bts.sio.paris2024kotlin.viewmodel.olympiade

import androidx.lifecycle.ViewModel
import bts.sio.paris2024kotlin.model.Olympiade
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OlympiadeViewModel : ViewModel() {

    private val _olympiades = MutableStateFlow<List<Olympiade>>(emptyList())
    val olympiades: StateFlow<List<Olympiade>> = _olympiades

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getOlympiades()
    }


    private fun getOlympiades() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getOlympiades()
                _olympiades.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }


}