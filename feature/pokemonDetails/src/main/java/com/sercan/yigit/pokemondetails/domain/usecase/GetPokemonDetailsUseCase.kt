package com.sercan.yigit.pokemondetails.domain.usecase

import com.sercan.yigit.network.util.UiEvents
import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails
import com.sercan.yigit.pokemondetails.domain.repository.PokemonDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonDetailsUseCase @Inject constructor(private val pokemonDetailsRepository: PokemonDetailsRepository) {

    operator fun invoke(id: String): Flow<UiEvents<PokemonDetails>> = flow {
        emit(UiEvents.Loading())
        emit(UiEvents.Success(pokemonDetailsRepository.getPokemonDetails(id)))
    }.catch {
        emit(UiEvents.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}