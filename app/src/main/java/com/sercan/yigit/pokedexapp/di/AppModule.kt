package com.sercan.yigit.pokedexapp.di

import com.sercan.yigit.pokedexapp.navigation.NavigationProvider
import com.sercan.yigit.pokemonlist.presentation.navigation.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(pokemonApi: PokemonApi): NavigationProvider {
        return NavigationProvider(pokemonApi)
    }

}

