package bts.sio.paris2024kotlin.viewmodel.site

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.paris2024kotlin.model.Site
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SiteViewModel : ViewModel() {

    private val _sites = MutableStateFlow<List<Site>>(emptyList())
    val sites: StateFlow<List<Site>> = _sites

    init {
        getSites()
    }

    private fun getSites() {
        viewModelScope.launch {
            _sites.value = listOf(
                Site(1, "Arena Porte de la Chapelle", "30 Rue André Bréchet", 75017, "Paris"),
                Site(2, "Centre sportif Max-Rousié", "30 Rue André Bréchet", 75017, "Paris"),
                Site(3, "Parc des sports Auguste-Delaune", "9 Avenue Roger-Sémat", 93200, "Saint-Denis")
            )
        }
    }
}