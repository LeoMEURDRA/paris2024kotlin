package bts.sio.paris2024kotlin.model

import java.time.LocalDate

data class Promotion(
    val id: Int,
    val date: LocalDate,
    val duree: Int,
    val descriptif: String,
)
