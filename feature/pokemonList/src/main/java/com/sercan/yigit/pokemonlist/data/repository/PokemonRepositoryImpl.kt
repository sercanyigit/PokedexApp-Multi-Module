package com.sercan.yigit.pokemonlist.data.repository

import com.sercan.yigit.pokemonlist.domain.model.Pokemon
import com.sercan.yigit.pokemonlist.domain.repository.PokemonRepository
import com.sercan.yigit.network.dataproviders.PokemonDataProviders
import com.sercan.yigit.pokemonlist.data.mapper.toDomainPokemonList
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonDataProviders: PokemonDataProviders) :
    PokemonRepository {

    override suspend fun getPokemonList(): List<Pokemon> {
        return pokemonDataProviders.getPokemonList().toDomainPokemonList()
    }

}