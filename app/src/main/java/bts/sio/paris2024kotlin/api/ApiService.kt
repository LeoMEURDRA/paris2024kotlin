package bts.sio.paris2024kotlin.api

import bts.sio.paris2024kotlin.model.Athlete
import bts.sio.paris2024kotlin.model.Olympiade
import bts.sio.paris2024kotlin.model.Pays
import bts.sio.paris2024kotlin.model.Promotion
import bts.sio.paris2024kotlin.model.Site
import bts.sio.paris2024kotlin.model.Sport
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("sport/lister")
    suspend fun getLesSports(): List<Sport>

    @GET("athlete/pays/{paysId}")
    suspend fun getLesAthletesByPays(@Path("paysId") paysId: Int): List<Athlete>

    @GET("athlete/lister")
    suspend fun getLesAthletes(): List<Athlete>

    @GET("olympiade/lister")
    suspend fun getLesOlympiades(): List<Olympiade>

    @GET("site/lister")
    suspend fun getLesSites(): List<Site>

    @GET("pays/lister")
    suspend fun getLesPays(): List<Pays>

    @POST("pays/ajouter")
    suspend fun addPays(@Body pays: Pays): Response<Pays>

    @GET("pays/consulter/{id}")
    suspend fun getPays(@Path("id") id: Int): Response<Pays>

    @GET("promotion/lister")
    suspend fun getLesPromotions(): List<Promotion>
}