package edu.curso.android.starships.data.api

import retrofit2.Call
import retrofit2.http.GET


interface StarshipsApi {

    @GET("starships/")
    fun getStarships(): Call<StarshipsResponse>
}
