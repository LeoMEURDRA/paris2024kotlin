package bts.sio.paris2024kotlin.views.pays

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.pays.PaysViewModel

@Composable
fun PaysList(viewModel: PaysViewModel = viewModel()) {
    val pays by viewModel.pays.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(pays) { pays ->
            PaysCard(pays = pays)
        }
    }
}