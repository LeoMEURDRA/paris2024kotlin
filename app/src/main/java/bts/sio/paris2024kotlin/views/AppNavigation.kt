package bts.sio.paris2024kotlin.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import bts.sio.paris2024kotlin.views.athlete.AthleteList
import bts.sio.paris2024kotlin.views.olympiade.OlympiadeList
import bts.sio.paris2024kotlin.views.pays.PaysList
import bts.sio.paris2024kotlin.views.site.SiteList
import bts.sio.paris2024kotlin.views.sport.SportList

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "sports_list",
        modifier = modifier
    ) {
        composable("sports_list") {
            SportList()
        }
        composable("athletes_list") {
            AthleteList()
        }
        composable("olympiades_list") {
            OlympiadeList()
        }
        composable("pays_list") {
            PaysList()
        }
        composable("sites_list") {
            SiteList()
        }
    }
}