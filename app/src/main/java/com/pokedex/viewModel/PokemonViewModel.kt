package com.pokedex.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pokedex.api.model.PokemonRepository
import com.pokedex.domain.Pokemon

class PokemonViewModel:ViewModel() {
    var pokemons = MutableLiveData<List<Pokemon?>>()
    init{
        Thread(Runnable {
            loadPokemons()
        }).start()
    }
    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()
        pokemonsApiResult?.results?.let {
            pokemons.postValue(it.map { pokemonResult ->
                val number =
                    pokemonResult.url
                        .replace("https://pokeapi.co/api/v2/pokemon/", "")
                        .replace("/", "").toInt()
                val pokemonApiResult = PokemonRepository.getPokemon(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}
