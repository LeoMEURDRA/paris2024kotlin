package bts.sio.paris2024kotlin.api

import bts.sio.paris2024kotlin.model.Athlete
import bts.sio.paris2024kotlin.model.Olympiade
import bts.sio.paris2024kotlin.model.Pays
import bts.sio.paris2024kotlin.model.Sport
import bts.sio.paris2024kotlin.model.Site
import retrofit2.http.GET

interface ApiService {
    @GET("/sports")
    suspend fun getSports(): List<Sport>

    @GET("/athletes")
    suspend fun getAthletes(): List<Athlete>

    @GET("/olympiades")
    suspend fun getOlympiades(): List<Olympiade>

    @GET("/sites")
    suspend fun getSites(): List<Site>

    @GET("/pays")
    suspend fun getPays(): List<Pays>
}