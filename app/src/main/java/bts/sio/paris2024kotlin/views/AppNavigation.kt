package bts.sio.paris2024kotlin.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "sports_list",
        modifier = modifier
    ) {
        composable("sports_list") {
            Text("Page sports")
        }
        composable("athletes_list") {
            Text("Page athletes")
        }
        composable("olympiades_list") {
            Text("Page olympiades")
        }
        composable("pays_list") {
            Text("Page pays")
        }
        composable("sites_list") {
            Text("Page sites")
        }
    }
}