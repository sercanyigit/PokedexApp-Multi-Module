package com.sercan.yigit.network

import com.sercan.yigit.network.model.PokemonDetailsDto
import com.sercan.yigit.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon/?offset=0&limit=1010")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: String): PokemonDetailsDto

}