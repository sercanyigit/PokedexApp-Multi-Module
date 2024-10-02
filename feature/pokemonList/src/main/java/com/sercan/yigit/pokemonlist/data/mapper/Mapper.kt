package com.sercan.yigit.pokemonlist.data.mapper

import com.sercan.yigit.pokemonlist.domain.model.Pokemon
import com.sercan.yigit.network.model.PokemonListResponse

fun PokemonListResponse.toDomainPokemonList(): List<Pokemon> {
    return this.results.map {
        Pokemon(id = it.getId(), name = it.name)
    }
}