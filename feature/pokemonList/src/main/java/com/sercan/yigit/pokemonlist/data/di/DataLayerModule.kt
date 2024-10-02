package com.sercan.yigit.pokemonlist.data.di

import com.sercan.yigit.pokemonlist.data.repository.PokemonRepositoryImpl
import com.sercan.yigit.pokemonlist.domain.repository.PokemonRepository
import com.sercan.yigit.network.dataproviders.PokemonDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun providePokemonRepository(pokemonDataProviders: PokemonDataProviders): PokemonRepository {
        return PokemonRepositoryImpl(pokemonDataProviders)
    }

}