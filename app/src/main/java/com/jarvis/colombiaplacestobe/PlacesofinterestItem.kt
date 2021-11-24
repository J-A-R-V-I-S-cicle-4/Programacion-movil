package com.jarvis.colombiaplacestobe
import com.google.gson.annotations.SerializedName


data class PlacesofinterestItem(
    @SerializedName("calificacion")
    val calificacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)