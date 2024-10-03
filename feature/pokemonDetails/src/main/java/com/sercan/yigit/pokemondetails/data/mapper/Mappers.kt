package com.sercan.yigit.pokemondetails.data.mapper

import com.sercan.yigit.network.model.PokemonDetailsDto
import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails

fun PokemonDetailsDto.toDomain(): PokemonDetails {
    return PokemonDetails(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        type = this.types.map { it.type.name }
    )
}