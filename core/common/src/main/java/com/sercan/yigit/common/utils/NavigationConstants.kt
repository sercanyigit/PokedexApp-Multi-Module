package com.sercan.yigit.common.utils

object PokemonFeature {
    const val nestedRoute = "pokemon_list_route"
    const val pokemonScreenRoute = "pokemon_list_screen_route"
    const val deepLinkRoute = "pokedex://"
}

object PokemonDetailsFeature {
    const val nestedRoute = "pokemon_details_route"
    const val pokemonDetailsScreenRoute = "pokemon_details/{id}"
    const val deepLinkRoute = "pokedex://pokemon/{id}"
}