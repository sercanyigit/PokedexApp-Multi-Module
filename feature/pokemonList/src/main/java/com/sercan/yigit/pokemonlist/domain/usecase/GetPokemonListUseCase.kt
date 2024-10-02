package com.sercan.yigit.pokemonlist.domain.usecase

import com.sercan.yigit.network.util.UiEvents
import com.sercan.yigit.pokemonlist.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(private val pokemonRepository: PokemonRepository) {

    operator fun invoke() = flow {
        emit(UiEvents.Loading())
        emit(UiEvents.Success(pokemonRepository.getPokemonList()))
    }.catch {
        emit(UiEvents.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)

}