package com.sercan.yigit.pokemonlist.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sercan.yigit.common.utils.isNumeric
import com.sercan.yigit.network.util.StateHolder
import com.sercan.yigit.network.util.UiEvents
import com.sercan.yigit.pokemonlist.domain.model.Pokemon
import com.sercan.yigit.pokemonlist.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonList = mutableStateOf(StateHolder<List<Pokemon>>())
    val pokemonList: State<StateHolder<List<Pokemon>>> get() = _pokemonList

    private val _query: MutableStateFlow<String> = MutableStateFlow("")
    val query: StateFlow<String> get() = _query

    init {
        viewModelScope.launch {
            _query.debounce(100).collectLatest {
                getPokemonList()
            }
        }
    }

    fun setQuery(s: String) {
        _query.value = s
    }

    fun getPokemonList() = viewModelScope.launch {
        getPokemonListUseCase().onEach {
            when(it) {
                is UiEvents.Loading -> {
                    _pokemonList.value = StateHolder(isLoading = true)
                }
                is UiEvents.Error -> {
                    _pokemonList.value = StateHolder(error = it.message.toString())
                }
                is UiEvents.Success -> {
                    if (isNumeric(query.value)) {
                        _pokemonList.value = StateHolder(data = it.data?.filter {
                                filter -> filter.id.contains(_query.value)
                        })
                    } else if(_query.value.isNotBlank()) {
                        _pokemonList.value = StateHolder(data = it.data?.filter {
                                filter -> filter.name.contains(_query.value)
                        })
                    } else {
                        _pokemonList.value = StateHolder(data = it.data)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}