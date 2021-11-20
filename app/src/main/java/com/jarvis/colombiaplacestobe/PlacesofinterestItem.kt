package com.jarvis.colombiaplacestobe


import com.google.gson.annotations.SerializedName

data class PlacesofinterestItem(
    @SerializedName("calificacion")
    val calificacion: Double,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)