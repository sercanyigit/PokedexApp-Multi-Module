package com.sercan.yigit.pokemondetails.presentation.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sercan.yigit.network.util.StateHolder
import com.sercan.yigit.network.util.UiEvents
import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails
import com.sercan.yigit.pokemondetails.domain.usecase.GetPokemonDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _pokemonDetails = MutableStateFlow(StateHolder<PokemonDetails>())
    val pokemonDetails: StateFlow<StateHolder<PokemonDetails>> get() = _pokemonDetails

    init {
        savedStateHandle.getLiveData<String>("id").observeForever {
            it?.let {
                getPokemonDetails(it)
            }
        }
    }

    private fun getPokemonDetails(id: String) {
        getPokemonDetailsUseCase(id).onEach {
            when (it) {
                is UiEvents.Loading -> {
                    _pokemonDetails.value = StateHolder(isLoading = true)
                }

                is UiEvents.Error -> {
                    _pokemonDetails.value = StateHolder(error = it.message.toString())
                }

                is UiEvents.Success -> {
                    _pokemonDetails.value = StateHolder(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}