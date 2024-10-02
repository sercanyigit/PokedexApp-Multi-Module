package com.sercan.yigit.pokemonlist.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.sercan.yigit.navigation.NavigationBuilder

interface PokemonApi : NavigationBuilder

class PokemonApiImpl : PokemonApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalPokemonFeatureApi.registerGraph(
            navController, navGraphBuilder
        )
    }
}