package bts.sio.paris2024kotlin.views.athlete

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.athlete.AthleteViewModel

@Composable
fun AthleteList(viewModel: AthleteViewModel = viewModel()) {
    val athletes by viewModel.athletes.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(athletes) { athlete ->
            AthleteCard(athlete = athlete)
        }
    }
}