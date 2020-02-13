package edu.curso.android.starships.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import edu.curso.android.starships.R
import edu.curso.android.starships.domain.entities.Starship
import kotlinx.android.synthetic.main.activity_starship_detail.*


class StarshipDetailActivity : AppCompatActivity() {

    companion object {
        const val STARSHIP_DETAIL = "STARSHIP_DETAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starship_detail)
        val starship: Starship = intent.extras?.getParcelable<Starship>(STARSHIP_DETAIL) as Starship
        showStarshipDetail(starship)
    }

   private fun showStarshipDetail(starship: Starship) {
    val name: TextView = findViewById(R.id.starship_name_value)
       name.text= starship.name

    val model: TextView = findViewById(R.id.starship_model_value)
       model.text= starship.model

    val manufacturer: TextView= findViewById(R.id.starship_manufacturer_value)
       manufacturer.text= starship.manufacturer

    val length: TextView= findViewById(R.id.starship_length_value)
       length.text = starship.length

    val crew: TextView= findViewById(R.id.starship_crew_value)
       crew.text= starship.crew

    val cost: TextView= findViewById(R.id.starship_cost_value)
       cost.text= starship.cost
    }


}
