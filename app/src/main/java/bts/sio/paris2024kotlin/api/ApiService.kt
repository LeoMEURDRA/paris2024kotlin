package bts.sio.paris2024kotlin.api

import bts.sio.paris2024kotlin.model.Athlete
import bts.sio.paris2024kotlin.model.Olympiade
import bts.sio.paris2024kotlin.model.Sport
import retrofit2.http.GET

interface ApiService {
    @GET("/sports")
    suspend fun getSports(): List<Sport>

    @GET("/athletes")
    suspend fun getAthletes(): List<Athlete>

    @GET("/olympiades")
    suspend fun getOlympiades(): List<Olympiade>
}