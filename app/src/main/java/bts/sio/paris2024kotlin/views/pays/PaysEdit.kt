package bts.sio.paris2024kotlin.views.pays

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.paris2024kotlin.model.Pays
import bts.sio.paris2024kotlin.viewmodel.pays.PaysViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable

fun PaysEdit(
    paysId: Int,
    navController: NavController,
    viewModel: PaysViewModel = viewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val pays by viewModel.pays.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()
    val operationSuccess by viewModel.operationSuccess.collectAsState()

    var nom by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var showErrorDialog by remember { mutableStateOf(false) }

    // Charger les données du pays à modifier
    LaunchedEffect(paysId) {
        viewModel.getPays(paysId)
    }

    // Mettre à jour les champs une fois les données chargées
    LaunchedEffect(pays) {
        pays?.let {
            nom = it.nom
            code = it.code
        }
    }

    LaunchedEffect(operationSuccess) {
        if (operationSuccess) {
            viewModel.resetOperationStatus()
            navController.popBackStack()
        }
    }

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    if (showErrorDialog && errorMessage != null) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = { Text("Erreur") },
            text = { Text(errorMessage ?: "Une erreur est survenue") },
            confirmButton = {
                TextButton(onClick = { showErrorDialog = false }) {
                    Text("OK")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Modifier un pays",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom du pays") },
            modifier = Modifier.fillMaxWidth(),
            isError = nom.isBlank()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Descriptif") },
            modifier = Modifier.fillMaxWidth(),
            isError = code.isBlank()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = { navController.popBackStack() }
            ) {
                Text("Annuler")
            }

            Button(
                onClick = {
                    if (nom.isNotBlank() && code.isNotBlank()) {
                        val updatedPays = Pays(
                            id = paysId,
                            nom = nom,
                            code = code
                        )

                        coroutineScope.launch {
                            try {
                                viewModel.addPays(updatedPays)
                            } catch (e: Exception) {
                                showErrorDialog = true
                            }
                        }
                    } else {
                        showErrorDialog = true
                    }
                },
                enabled = nom.isNotBlank() && code.isNotBlank() && !isLoading
            ) {
                Text("Enregistrer")
            }
        }
    }
}