package bts.sio.paris2024kotlin.views.promotion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.paris2024kotlin.model.Promotion
import java.time.format.DateTimeFormatter

@Composable
fun PromotionCard(promotion: Promotion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

            Text(text = "Promotion du ${promotion.date.format(formatter)}", style = MaterialTheme.typography.bodyLarge)
            Text(text = promotion.descriptif, style = MaterialTheme.typography.bodyMedium)
        }
    }
}