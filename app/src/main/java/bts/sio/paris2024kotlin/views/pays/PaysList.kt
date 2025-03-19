package bts.sio.paris2024kotlin.views.pays

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.pays.PaysViewModel
import androidx.compose.material3.Text
import androidx.navigation.NavController

@Composable
fun PaysList(viewModel: PaysViewModel = viewModel(), navController: NavController) {
    val pays by viewModel.paysList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(pays) { pays ->
                PaysCard(pays = pays, navController = navController)
            }
        }
    }
}
