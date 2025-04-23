package bts.sio.paris2024.views.pays

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import bts.sio.paris2024kotlin.model.Pays
import bts.sio.paris2024kotlin.viewmodel.pays.PaysViewModel

@Composable
fun PaysAdd(navController: NavController) {
    val viewModel: PaysViewModel = viewModel()
    var code by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        OutlinedTextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nom.isNotBlank() && code.isNotBlank()) {
                    val pays = Pays(id = 0, code = code, nom = nom)
                    viewModel.addPays(pays)
                    navController.navigate("pays_list")
                }
            },
            modifier = Modifier.align(Alignment.End),
            enabled = nom.isNotBlank()
        )
        {
            Text("Ajouter le pays")
        }
    }
}