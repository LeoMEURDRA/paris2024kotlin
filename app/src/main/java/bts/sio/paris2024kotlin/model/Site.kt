package bts.sio.paris2024kotlin.model

data class Site(
    val id: Int,
    val nom: String,
    val rue: String,
    val code_postal: Int,
    val ville: String
)