package bts.sio.paris2024kotlin.viewmodel.athlete

import androidx.lifecycle.ViewModel
import bts.sio.paris2024kotlin.model.Athlete
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AthleteViewModel : ViewModel() {

    private val _athletes = MutableStateFlow<List<Athlete>>(emptyList())
    val athletes: StateFlow<List<Athlete>> = _athletes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun getLesAthletes() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getLesAthletes()
                _athletes.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }

    fun getLesAthletesByPays(pays_id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getLesAthletesByPays(pays_id)
                _athletes.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }


}