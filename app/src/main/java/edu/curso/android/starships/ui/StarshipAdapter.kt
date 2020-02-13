package edu.curso.android.starships.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.curso.android.starships.R
import edu.curso.android.starships.domain.entities.Starship


class StarshipAdapter(val starships: List<Starship>) :
    RecyclerView.Adapter<StarshipAdapter.StarshipViewHolder>() {

    interface  StarshipListListener{
        fun onItemClick(starship: Starship)
    }

    var listener: StarshipListListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StarshipViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.adapter_starship, parent, false)
        return StarshipViewHolder(view)
    }

    override fun onBindViewHolder(holder: StarshipViewHolder, position: Int) {
        val starship = starships[position]

        holder.name.text = starship.name
        holder.model.text = starship.model
        holder.itemView.setOnClickListener{listener?.onItemClick(starship)}
        Log.i("TAG", "${starship.name}")
    }

    override fun getItemCount(): Int = starships.size

    class StarshipViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.starship_name)
        val model: TextView = view.findViewById(R.id.starship_model)
    }
}

