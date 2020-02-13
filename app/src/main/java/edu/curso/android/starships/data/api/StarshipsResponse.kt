package edu.curso.android.starships.data.api

import com.google.gson.annotations.SerializedName
import edu.curso.android.starships.domain.entities.Starship


data class StarshipsResponse (
    @SerializedName("results")
    val result: List<StarshipResponse>
)
