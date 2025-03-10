package bts.sio.paris2024kotlin.api

import bts.sio.paris2024kotlin.model.Sport
import retrofit2.http.GET

interface ApiService {
    @GET("/sports")
    suspend fun getSports(): List<Sport>
}