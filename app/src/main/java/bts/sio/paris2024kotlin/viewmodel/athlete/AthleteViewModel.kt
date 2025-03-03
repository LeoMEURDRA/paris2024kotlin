package bts.sio.paris2024kotlin.viewmodel.athlete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.model.Athlete
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class AthleteViewModel : ViewModel() {

    private val _athletes = MutableStateFlow<List<Athlete>>(emptyList())
    val athletes: StateFlow<List<Athlete>> = _athletes

    init {
        getAthletes()
    }

    private fun getAthletes() {
        viewModelScope.launch {
            _athletes.value = listOf(
                Athlete(1, "Mbappé", "Kylian", LocalDate.of(1998, 12, 20)),
                Athlete(2, "Hegerberg", "Ada", LocalDate.of(1995, 7, 10)),
                Athlete(3, "Fournier", "Evan", LocalDate.of(1992, 10, 29)),
                Athlete(4, "Delle Donne", "Elena", LocalDate.of(1989, 9, 5)),
                Athlete(5, "Djokovic", "Novak", LocalDate.of(1987, 5, 22)),
                Athlete(6, "Świątek", "Iga", LocalDate.of(2001, 5, 31))
            )
        }
    }
}