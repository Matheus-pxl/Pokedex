package com.pokedex.api.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    val URL = "https://pokeapi.co/api/v2/"
    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151):PokemonsApiResult? {
        val call = service.listPokemons(limit)
        return call.execute().body()
    }
    fun getPokemon(number:Int):PokemonApiResult? {
        val call = service.getPokemon(number)
        return call.execute().body()
    }
}