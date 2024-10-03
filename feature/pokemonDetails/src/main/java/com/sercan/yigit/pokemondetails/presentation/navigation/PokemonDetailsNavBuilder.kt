package com.sercan.yigit.pokemondetails.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.sercan.yigit.navigation.NavigationBuilder

interface PokemonDetailsNavBuilder: NavigationBuilder

class PokemonDetailsApiImpl: PokemonDetailsNavBuilder {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        PokemonDetailsRegisterGraph.registerGraph(navController, navGraphBuilder)
    }

}