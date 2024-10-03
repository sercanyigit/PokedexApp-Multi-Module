package com.sercan.yigit.pokemondetails.domain.repository

import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails

interface PokemonDetailsRepository {

    suspend fun getPokemonDetails(id: String) : PokemonDetails

}