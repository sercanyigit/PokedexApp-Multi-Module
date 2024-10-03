package com.sercan.yigit.pokemondetails.presentation.di

import com.sercan.yigit.pokemondetails.presentation.navigation.PokemonDetailsApiImpl
import com.sercan.yigit.pokemondetails.presentation.navigation.PokemonDetailsNavBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {

    @Provides
    fun providePokemonDetailsApi(): PokemonDetailsNavBuilder {
        return PokemonDetailsApiImpl()
    }

}