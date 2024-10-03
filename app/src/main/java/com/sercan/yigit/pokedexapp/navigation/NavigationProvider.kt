package com.sercan.yigit.pokedexapp.navigation
import com.sercan.yigit.pokemondetails.presentation.navigation.PokemonDetailsNavBuilder
import com.sercan.yigit.pokemonlist.presentation.navigaton.PokemonListNavBuilder

data class NavigationProvider(
    val pokemonListNavBuilder: PokemonListNavBuilder,
    val pokemonDetailsNavBuilder: PokemonDetailsNavBuilder
)