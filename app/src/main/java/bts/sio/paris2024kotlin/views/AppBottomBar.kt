package bts.sio.paris2024kotlin.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController

@Composable
fun AppBottomBar(navController: NavController) {

    val items = listOf(
        BottomNavItem("Sports", "sports_list", Icons.Filled.Sports),
        BottomNavItem("Athletes", "athletes_list", Icons.Filled.Person),
        BottomNavItem("Olympiades", "olympiades_list", Icons.Filled.EmojiEvents),
        BottomNavItem("Pays", "pays_list", Icons.Filled.Flag),
        BottomNavItem("Sites", "sites_list", Icons.Filled.Map)
    )

    var selectedItem by remember { mutableStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                }
            )
        }
    }
}

data class BottomNavItem(val label: String, val route: String, val icon: ImageVector)