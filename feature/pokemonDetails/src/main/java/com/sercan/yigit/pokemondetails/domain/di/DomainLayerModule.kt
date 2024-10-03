package com.sercan.yigit.pokemondetails.domain.di

import com.sercan.yigit.pokemondetails.domain.repository.PokemonDetailsRepository
import com.sercan.yigit.pokemondetails.domain.usecase.GetPokemonDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetPokemonDetailsUseCase(pokemonDetailsRepository: PokemonDetailsRepository): GetPokemonDetailsUseCase {
        return GetPokemonDetailsUseCase(pokemonDetailsRepository)
    }

}