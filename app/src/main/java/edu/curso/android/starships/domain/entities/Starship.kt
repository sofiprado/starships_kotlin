package edu.curso.android.starships.domain.entities

import android.os.Parcelable
import edu.curso.android.starships.data.api.StarshipResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class Starship(
    val name: String,
    val model: String,
    val crew: String,
    val manufacturer: String,
    val cost: String,
    val length: String

) : Parcelable {
    constructor(starshipResponse: StarshipResponse): this (
        starshipResponse.name,
        starshipResponse.model,
        starshipResponse.crew,
        starshipResponse.manufacturer,
        starshipResponse.cost,
        starshipResponse.length
    )
}