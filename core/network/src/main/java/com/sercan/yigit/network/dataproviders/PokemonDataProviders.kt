package com.sercan.yigit.network.dataproviders

import com.sercan.yigit.network.ApiService
import javax.inject.Inject

class PokemonDataProviders @Inject constructor(private val apiService: ApiService) {

    suspend fun getPokemonList() = apiService.getPokemonList()

    suspend fun getPokemonDetails(id: String) = apiService.getPokemonDetails(id)

}