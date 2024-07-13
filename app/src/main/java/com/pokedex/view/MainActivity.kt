package com.pokedex.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pokedex.databinding.ActivityMainBinding
import com.pokedex.domain.Pokemon
import com.pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charmandar = Pokemon(
            "https://www.pokemon.com/static-assets/content-assets/cms2/img/pokedex/full/004.png",
            4, "charmander", listOf(PokemonType("Fire"))
        )
        val pokemons = listOf(
            charmandar,charmandar,charmandar,charmandar,charmandar,charmandar,charmandar,charmandar
        )

        val recyclerView = binding.recyclerViewPokemons
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}