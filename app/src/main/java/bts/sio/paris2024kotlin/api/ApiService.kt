package bts.sio.paris2024kotlin.api

import bts.sio.paris2024kotlin.model.Athlete
import bts.sio.paris2024kotlin.model.Olympiade
import bts.sio.paris2024kotlin.model.Pays
import bts.sio.paris2024kotlin.model.Sport
import bts.sio.paris2024kotlin.model.Site
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/sport/lister")
    suspend fun getLesSports(): List<Sport>

    @GET("/athlete/lister")
    suspend fun getLesAthletes(): List<Athlete>

    @GET("/athlete/pays/{pays_id}")
    suspend fun getLesAthletesByPays(@Path("pays_id") pays_id: Int): List<Athlete>

    @GET("/olympiade/lister")
    suspend fun getLesOlympiades(): List<Olympiade>

    @GET("/site/lister")
    suspend fun getLesSites(): List<Site>

    @GET("/pays/lister")
    suspend fun getLesPays(): List<Pays>

    @GET("/pays/consulter")
    suspend fun getPays(pays_id: Int): Response<Pays>
}