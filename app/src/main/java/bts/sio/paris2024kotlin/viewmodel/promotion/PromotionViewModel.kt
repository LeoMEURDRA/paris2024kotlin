package bts.sio.paris2024kotlin.viewmodel.promotion

import androidx.lifecycle.ViewModel
import bts.sio.paris2024kotlin.model.Promotion
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PromotionViewModel : ViewModel() {

    private val _promotion_list = MutableStateFlow<List<Promotion>>(emptyList())
    val promotion_list: StateFlow<List<Promotion>> = _promotion_list

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getLesPromotions()
    }

    private fun getLesPromotions() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getLesPromotions()
                _promotion_list.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }
}