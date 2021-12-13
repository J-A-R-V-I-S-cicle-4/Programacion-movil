package com.jarvis.poi.data

import com.jarvis.poi.model.Placesofinterest
import retrofit2.http.GET

interface ApiService {

    @GET("J-A-R-V-I-S-cicle-4/Programacion-movil/placesofinterest")
    suspend fun getPlacesofinterest(): Placesofinterest
}