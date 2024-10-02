package com.sercan.yigit.pokemonlist.domain.di

import com.sercan.yigit.pokemonlist.domain.repository.PokemonRepository
import com.sercan.yigit.pokemonlist.domain.usecase.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetPokemonListUseCase(pokemonRepository: PokemonRepository): GetPokemonListUseCase {
        return GetPokemonListUseCase(pokemonRepository)
    }

}