package com.sercan.yigit.pokemonlist.domain.repository

import com.sercan.yigit.pokemonlist.domain.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemonList(): List<Pokemon>

}