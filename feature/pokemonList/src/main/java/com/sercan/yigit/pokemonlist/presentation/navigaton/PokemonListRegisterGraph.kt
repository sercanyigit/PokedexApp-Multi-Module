package com.sercan.yigit.pokemonlist.presentation.navigaton

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.sercan.yigit.navigation.PokemonFeature
import com.sercan.yigit.navigation.NavigationBuilder
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonScreen

internal object PokemonListRegisterGraph : NavigationBuilder {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = PokemonFeature.pokemonScreenRoute, route = PokemonFeature.nestedRoute) {
            composable(
                PokemonFeature.pokemonScreenRoute,
                deepLinks = listOf(navDeepLink { uriPattern = PokemonFeature.deepLinkRoute })
            ) {
                PokemonScreen(navController)
            }
        }
    }
}