package bts.sio.paris2024kotlin.views.athlete

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.viewmodel.athlete.AthleteViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import bts.sio.paris2024kotlin.viewmodel.pays.PaysViewModel

@Composable
fun AthleteList(pays_id: Int? = null, athleteViewModel: AthleteViewModel = viewModel(), paysViewModel: PaysViewModel = viewModel()) {
    val athletes by athleteViewModel.athletes.collectAsState()
    val isLoading by athleteViewModel.isLoading.collectAsState()
    val errorMessage by athleteViewModel.errorMessage.collectAsState()
    val pays by paysViewModel.pays.collectAsState()

    LaunchedEffect(pays_id) {
        if (pays_id == null) {
            athleteViewModel.getLesAthletes()
        }
        else {
            athleteViewModel.getLesAthletesByPays(pays_id)
            paysViewModel.getPays(pays_id)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            errorMessage != null -> {
                Text(
                    text = errorMessage ?: "Erreur inconnue",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }
            else -> {


                LazyColumn {

                    // BLOC D'INFOS SUR LE PAYS SI SELECTIONNE AVANT
                    if (pays != null) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally // Centrer le contenu horizontalement
                            ) {
                                Text(
                                    text = "Informations sur le pays",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Nom : ${pays?.nom ?: "Non défini"}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Code : ${pays?.code ?: "Non défini"}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }
                    }

                    // S'il y a des athletes
                    if (athletes.isNotEmpty()) {


                        // Titre Liste des athletes
                        item {
                            Text(
                                text = "Liste des athletes",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp)
                                    .padding(16.dp),
                                textAlign = TextAlign.Center, // Alignement à gauche
                                color = MaterialTheme.colorScheme.primary
                            )
                        }


                        // Liste des athletes
                        items(athletes) { athlete ->
                            AthleteCard(athlete = athlete)
                        }
                    }

                    else {
                        // Il n'y a pas d'athlete pour ce pays
                        item {
                            Text(
                                text = "Pas d'athlete pour ce pays",
                                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 1.dp)
                                    .padding(16.dp),
                                textAlign = TextAlign.Center, // Alignement à gauche
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    }

}