package com.pokedex.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.R
import com.pokedex.domain.Pokemon

class PokemonAdapter(
    private val items: List<Pokemon>
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bindView(item: Pokemon) = with(itemView) {
            val imagePokemon = findViewById<ImageView>(R.id.imageViewPokemon)
            val textNumber = findViewById<TextView>(R.id.textNumeroPokemon)
            val textNome = findViewById<TextView>(R.id.textNomePokemon)
            val textType1 = findViewById<TextView>(R.id.textTypeElemento1)
            val textType2 = findViewById<TextView>(R.id.textTypeElemento2)

            //TODO load imagem with glide


            textNumber.text = "N° ${item.number}"
            textNome.text = item.name
            textType1.text = item.types[0].name

            if(item.types.size > 1){
                textType2.visibility = View.VISIBLE
                textType2.text = item.types[1].name
            }else{
                textType2.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item)
    }
}