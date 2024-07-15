package com.example.pokedex2

import android.util.Log
import com.pokedex.api.model.PokemonService
import com.pokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)
        return call.execute().body()

//        call.enqueue(object : Callback<PokemonsApiResult> {
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("POKEMON_API", "Erro ao carregar lista pokemon", t)
//            }
//
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>
//            ) {
//                if (response.isSuccessful) {
//                    val body = response.body()
//                    body?.results?.let {
//                        Log.d("POKEMON_API",it[0].name)
//                    }
//                Log.d("POKEMON_API", "lista pokemon carregada")
//                }
//            }
//        })
    }
}