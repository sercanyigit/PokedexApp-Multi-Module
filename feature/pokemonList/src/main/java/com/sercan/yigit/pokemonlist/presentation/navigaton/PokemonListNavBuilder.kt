package com.sercan.yigit.pokemonlist.presentation.navigaton

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.sercan.yigit.navigation.NavigationBuilder

interface PokemonListNavBuilder : NavigationBuilder

class PokemonListNavBuilderImpl : PokemonListNavBuilder {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        PokemonListRegisterGraph.registerGraph(
            navController, navGraphBuilder
        )
    }
}