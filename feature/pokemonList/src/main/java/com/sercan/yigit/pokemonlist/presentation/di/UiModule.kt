package com.sercan.yigit.pokemonlist.presentation.di
import com.sercan.yigit.pokemonlist.presentation.navigaton.PokemonListNavBuilder
import com.sercan.yigit.pokemonlist.presentation.navigaton.PokemonListNavBuilderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UiModule {
    @Provides
    fun providePokemonListNavigateImpl(): PokemonListNavBuilder {
        return PokemonListNavBuilderImpl()
    }
}