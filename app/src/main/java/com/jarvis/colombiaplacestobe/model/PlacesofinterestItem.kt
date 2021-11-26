package com.jarvis.colombiaplacestobe.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlacesofinterestItem(
    @SerializedName("calificacion")
    val calificacion: Double,
    @SerializedName("sitios")
    val sitios: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("informacion")
    val informacion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
) : Serializable