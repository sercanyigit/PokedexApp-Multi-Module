package com.sercan.yigit.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.sercan.yigit.common.utils.PokemonFeature
@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider
) {
    NavHost(navController = navController, startDestination = PokemonFeature.nestedRoute){
        navigationProvider.pokemonListNavBuilder.registerGraph(
            navController,this
        )
    }
}