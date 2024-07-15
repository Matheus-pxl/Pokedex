package com.pokedex.api.model

import com.pokedex.domain.Pokemon
import com.pokedex.domain.PokemonType

data class PokemonsApiResult(
    val count:Int,
    val next:String?,
    val previous:String?,
    val results: List<Pokemon>
)

data class PokemonApiResult(
    val id: Int,
    val name:String,
    val types: List<PokemonTypeSlot>
)

data class PokemonTypeSlot(
    val slot:Int,
    val type: PokemonType
)