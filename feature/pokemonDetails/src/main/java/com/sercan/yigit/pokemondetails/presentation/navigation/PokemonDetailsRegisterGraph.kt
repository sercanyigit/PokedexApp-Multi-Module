package com.sercan.yigit.pokemondetails.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.sercan.yigit.navigation.PokemonDetailsFeature
import com.sercan.yigit.navigation.NavigationBuilder
import com.sercan.yigit.pokemondetails.presentation.screen.PokemonDetailsScreen

object PokemonDetailsRegisterGraph: NavigationBuilder {

    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(route = PokemonDetailsFeature.nestedRoute, startDestination = PokemonDetailsFeature.pokemonDetailsScreenRoute) {
            composable(
                PokemonDetailsFeature.pokemonDetailsScreenRoute,
                deepLinks = listOf(navDeepLink { uriPattern = PokemonDetailsFeature.deepLinkRoute })
            ) {
                val id = it.arguments?.getString("id")
                PokemonDetailsScreen(id = id.toString(), navController)
            }
        }
    }
}