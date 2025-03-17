package bts.sio.paris2024kotlin.api

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object RetrofitInstance {
    private const val BASE_URL = "http://10.0.2.2:9005/"

    val localDateTypeAdapter: JsonDeserializer<LocalDate> = JsonDeserializer { json, _, _ ->
        LocalDate.parse(json.asString, DateTimeFormatter.ISO_LOCAL_DATE)
    }

    val gson = GsonBuilder()
        .registerTypeAdapter(LocalDate::class.java, localDateTypeAdapter)
        .create()

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}