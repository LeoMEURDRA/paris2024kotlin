package bts.sio.paris2024kotlin.viewmodel.pays

import androidx.lifecycle.ViewModel
import bts.sio.paris2024kotlin.model.Pays
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaysViewModel : ViewModel() {

    private val _pays = MutableStateFlow<List<Pays>>(emptyList())
    val pays: StateFlow<List<Pays>> = _pays

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getLesPays()
    }


    private fun getLesPays() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getLesPays()
                _pays.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }


}