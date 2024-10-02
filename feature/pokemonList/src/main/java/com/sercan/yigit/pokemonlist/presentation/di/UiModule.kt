package com.sercan.yigit.pokemonlist.presentation.di

import com.sercan.yigit.pokemonlist.presentation.navigation.PokemonApi
import com.sercan.yigit.pokemonlist.presentation.navigation.PokemonApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun providePokemonApi(): PokemonApi {
        return PokemonApiImpl()
    }

}