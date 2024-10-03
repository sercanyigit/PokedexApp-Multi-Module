package com.sercan.yigit.pokedexapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.sercan.yigit.pokedexapp.navigation.PokemonDetailsScreen
import com.sercan.yigit.pokedexapp.navigation.PokemonListScreen
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PokemonListScreen
    ) {
        composable<PokemonListScreen> {
            PokemonScreen(navController = navController)
            /*navController.navigate(PokemonDetailsScreen(
                id = 1
            ))*/
        }
        composable<PokemonDetailsScreen> {
            val args = it.toRoute<PokemonDetailsScreen>()
        }
    }
}