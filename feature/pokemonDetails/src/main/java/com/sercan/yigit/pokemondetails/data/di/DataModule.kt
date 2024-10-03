package com.sercan.yigit.pokemondetails.data.di

import com.sercan.yigit.pokemondetails.data.repository.PokemonDetailsRepositoryImpl
import com.sercan.yigit.network.dataproviders.PokemonDataProviders
import com.sercan.yigit.pokemondetails.domain.repository.PokemonDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun providePokemonDetailsRepository(pokemonDataProviders: PokemonDataProviders): PokemonDetailsRepository {
        return PokemonDetailsRepositoryImpl(pokemonDataProviders)
    }

}