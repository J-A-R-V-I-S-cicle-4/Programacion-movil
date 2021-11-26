package com.andresmolinasix.sprint2.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TurismoItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("information")
    val information: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Double,
    @SerializedName("url")
    val url: String,
    @SerializedName("url2")
    val url2: String
): Serializable