package bts.sio.paris2024kotlin.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import android.os.Build
import androidx.compose.material3.Text
import bts.sio.paris2024.views.pays.PaysAdd
import bts.sio.paris2024kotlin.views.athlete.AthleteList
import bts.sio.paris2024kotlin.views.olympiade.OlympiadeList
import bts.sio.paris2024kotlin.views.pays.PaysEdit
import bts.sio.paris2024kotlin.views.pays.PaysList
import bts.sio.paris2024kotlin.views.promotion.PromotionList
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
        composable("athletes_list?paysId={paysId}") { backStackEntry ->
            val paysId = backStackEntry.arguments?.getString("paysId")?.toIntOrNull()
            AthleteList(paysId = paysId)
        }
        composable("olympiades_list") {
            OlympiadeList()
        }
        composable("pays_list") {
            PaysList(navController = navController)
        }
        composable("pays_add") {
            PaysAdd(navController = navController)
        }
        composable("pays_edit/{paysId}") { backStackEntry ->
            val paysId = backStackEntry.arguments?.getString("paysId")?.toIntOrNull() ?: 0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                PaysEdit(paysId = paysId, navController = navController)
            } else {
                Text("Fonctionnalité non disponible sur cette version d'Android")
            }
        }
        composable("sites_list") {
            SiteList()
        }
        composable("promotions_list") {
            PromotionList()
        }
    }
}