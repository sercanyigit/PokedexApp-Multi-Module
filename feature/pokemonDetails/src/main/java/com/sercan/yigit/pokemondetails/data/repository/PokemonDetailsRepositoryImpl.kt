package com.sercan.yigit.pokemondetails.data.repository

import com.sercan.yigit.network.dataproviders.PokemonDataProviders
import com.sercan.yigit.pokemondetails.data.mapper.toDomain
import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails
import com.sercan.yigit.pokemondetails.domain.repository.PokemonDetailsRepository
import javax.inject.Inject

class PokemonDetailsRepositoryImpl @Inject constructor(private val pokemonDataProviders: PokemonDataProviders) :
    PokemonDetailsRepository {
    override suspend fun getPokemonDetails(id: String): PokemonDetails {
        return pokemonDataProviders.getPokemonDetails(id).toDomain()
    }
}