package bts.sio.paris2024kotlin.views.olympiade

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.olympiade.OlympiadeViewModel
import androidx.compose.material3.Text

@Composable
fun OlympiadeList(viewModel: OlympiadeViewModel = viewModel()) {
    val olympiades by viewModel.olympiades.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    when {
        isLoading -> CircularProgressIndicator()
        errorMessage != null -> Text(text = errorMessage!!, color = Color.Red)
        else -> LazyColumn {
            items(olympiades) { olympiade ->
                OlympiadeCard(olympiade = olympiade)
            }
        }
    }
}