package com.sercan.yigit.pokedexapp.navigation

import kotlinx.serialization.Serializable


@Serializable
object PokemonListScreen

@Serializable
data class PokemonDetailsScreen(
    val id: Int
)