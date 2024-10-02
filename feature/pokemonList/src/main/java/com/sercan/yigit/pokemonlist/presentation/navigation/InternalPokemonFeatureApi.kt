package com.sercan.yigit.pokemonlist.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonScreen
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonViewModel
import com.sercan.yigit.common.utils.PokemonFeature
import com.sercan.yigit.navigation.NavigationBuilder

internal object InternalPokemonFeatureApi : NavigationBuilder {

    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = PokemonFeature.pokemonScreenRoute, route = PokemonFeature.nestedRoute) {
            composable(
                PokemonFeature.pokemonScreenRoute,
                deepLinks = listOf(navDeepLink { uriPattern = PokemonFeature.deepLinkRoute })
            ) {
                val viewModel = hiltViewModel<PokemonViewModel>()
                PokemonScreen(viewModel = viewModel, navController)
            }
        }
    }
}