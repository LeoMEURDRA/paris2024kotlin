package bts.sio.paris2024kotlin.viewmodel.pays

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import bts.sio.paris2024kotlin.model.Pays
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

    private val _operationSuccess = MutableStateFlow(false)
    val operationSuccess: StateFlow<Boolean> = _operationSuccess

    init {
        getLesPays()
    }

    private fun getLesPays() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null
            try {
                val response = RetrofitInstance.api.getLesPays()
                _paysList.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement du pays terminé")
            }
        }
    }

    fun getPays(id : Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getPays(id)
                _pays.value = response.body()
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement du pays terminé")
            }
        }
    }

    fun addPays(pays: Pays) {
        viewModelScope.launch {
            _isLoading.value = true
            _operationSuccess.value = false
            try {
                val response = RetrofitInstance.api.addPays(pays)
                if (response.isSuccessful) {
                    getLesPays()
                    _operationSuccess.value = true
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du pays : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updatePays(pays: Pays) {
        viewModelScope.launch {
            _isLoading.value = true
            _operationSuccess.value = false
            try {
                val response = RetrofitInstance.api.addPays(pays)

                if (response.isSuccessful) {
                    getLesPays()
                    _operationSuccess.value = true
                } else {
                    _errorMessage.value = "Erreur lors de la modification du pays : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun resetOperationStatus() {
        _operationSuccess.value = false
        _errorMessage.value = null
    }
}