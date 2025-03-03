package bts.sio.paris2024kotlin.viewmodel.sport

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.model.Sport
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SportViewModel : ViewModel() {

    private val _sports = MutableStateFlow<List<Sport>>(emptyList())
    val sports: StateFlow<List<Sport>> = _sports

    init {
        getSports()
    }

    private fun getSports() {
        viewModelScope.launch {
            _sports.value = listOf(
                Sport(1, "Football", "Un sport collectif où deux équipes de 11 joueurs s'affrontent pour marquer des buts en envoyant un ballon dans le but adverse."),
                Sport(2, "Basket-ball", "Deux équipes de cinq joueurs tentent de marquer en lançant un ballon dans le panier de l’équipe adverse."),
                Sport(3, "Tennis", "Un sport individuel ou en double où les joueurs frappent une balle au-dessus d'un filet, en essayant de marquer des points dans le camp adverse."),
            )
        }
    }
}