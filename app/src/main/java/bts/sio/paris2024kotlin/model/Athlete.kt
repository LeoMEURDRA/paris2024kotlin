package bts.sio.paris2024kotlin.model

import java.time.LocalDate

data class Athlete(
    val id: Int,
    val nom: String,
    val prenom: String,
    val dateNaiss: LocalDate,
)