package bts.sio.paris2024kotlin.views.site

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.site.SiteViewModel

@Composable
fun SiteList(viewModel: SiteViewModel = viewModel()) {
    val sites by viewModel.sites.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(sites) { site ->
            SiteCard(site = site)
        }
    }
}