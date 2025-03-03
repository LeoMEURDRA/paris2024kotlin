package bts.sio.paris2024kotlin.views.athlete

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
import bts.sio.paris2024kotlin.model.Athlete
import java.time.format.DateTimeFormatter

@Composable
fun AthleteCard(athlete: Athlete) {
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
            val dateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
            val formattedDate = athlete.dateNaiss.format(dateFormatter)

            Text(text = "${athlete.nom} ${athlete.prenom}", style = MaterialTheme.typography.bodyLarge)
            Text(text = formattedDate, style = MaterialTheme.typography.bodyMedium)
        }
    }
}