package com.pokedex.api.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit")limit:Int = 151): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number:Int): Call<PokemonApiResult>
}