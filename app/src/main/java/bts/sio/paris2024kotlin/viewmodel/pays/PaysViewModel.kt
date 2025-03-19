package bts.sio.paris2024kotlin.viewmodel.pays

import androidx.lifecycle.ViewModel
import bts.sio.paris2024kotlin.model.Pays
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PaysViewModel : ViewModel() {

    private val _paysList = MutableStateFlow<List<Pays>>(emptyList())
    val paysList: StateFlow<List<Pays>> = _paysList

    private val _pays = MutableStateFlow<Pays?>(null)
    val pays: StateFlow<Pays?> = _pays

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
                _paysList.value = response  // Update with the list of Pays
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }

    fun getPays(pays_id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getPays(pays_id)
                _pays.value = response.body()  // Update with the single Pays object
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }

}