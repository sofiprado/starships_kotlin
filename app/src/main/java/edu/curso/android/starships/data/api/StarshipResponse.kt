package edu.curso.android.starships.data.api

import com.google.gson.annotations.SerializedName


data class StarshipResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("model")
    val model: String,
    @SerializedName ("crew")
    val crew: String,
    @SerializedName("manufacturer")
    val manufacturer: String,
    @SerializedName("cost_in_credits")
    val cost: String,
    @SerializedName("length")
     val length: String
)