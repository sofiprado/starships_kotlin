package edu.curso.android.starships.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.curso.android.starships.R
import edu.curso.android.starships.data.api.RetrofitApiClient
import edu.curso.android.starships.data.api.StarshipResponse
import edu.curso.android.starships.data.api.StarshipsApi
import edu.curso.android.starships.data.api.StarshipsResponse
import edu.curso.android.starships.domain.entities.Starship
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

companion object {
    private const val BASE_URL = "https://swapi.co/api"
}

    //::
    private val retrofitClient: StarshipsApi =
        RetrofitApiClient(BASE_URL).createService(StarshipsApi::class.java)

    //lateinit
    private lateinit var starshipsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starships)


        setRecyclerView()
        getStarships()
    }

        private fun setRecyclerView(){
            starshipsRecyclerView = findViewById(R.id.starships_list)
        }

    private fun getStarships() {
        retrofitClient.getStarships().enqueue(object : Callback<StarshipsResponse> {

            override fun onResponse(
                call: Call<StarshipsResponse>,
                response: Response<StarshipsResponse>
            ) {

                if (response.isSuccessful) {
                    val starshipsList = response.body()?.result?.map { starshipResponse -> Starship(starshipResponse) }
                    //enviar starshipsList a método que conecte con Adapter
                    sendStarshipsToLayout(starshipsList)
                } else
                    errorLog()

            }

            override fun onFailure(call: Call<StarshipsResponse>, t: Throwable) {
               errorLog()
            }
        })
    }

        private fun errorLog(){
            Log.d("error", "error en getStarships()")
        }

    private fun sendStarshipsToLayout(starshipsList: List<Starship>?){

        if (starshipsList.isNullOrEmpty())
            return

        val adapter = StarshipAdapter(starshipsList)
        adapter.listener = object : StarshipAdapter.StarshipListListener{
            override fun onItemClick(starship: Starship) {
                showStarshipDetail(starship)

            }
        }
            starshipsRecyclerView.layoutManager = LinearLayoutManager(this)
            starshipsRecyclerView.adapter = adapter
    }

    private fun showStarshipDetail(starship: Starship) {
        val intent = Intent(this, StarshipDetailActivity::class.java)
        intent.putExtra(StarshipDetailActivity.STARSHIP_DETAIL, starship)
        startActivity(intent)
    }
}
