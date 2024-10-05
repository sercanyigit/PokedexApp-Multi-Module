package com.sercan.yigit.pokemondetails.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorPokemonTypeMap
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.pokemondetails.domain.model.PokemonDetails

@Composable
fun PokemonTypeComponent( pokemonDetails: PokemonDetails){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp)
    ) {
        for (i in 0 until pokemonDetails.type.size) {
            val pokemonType = pokemonDetails.type[i] ?: ""
            Text(
                modifier = Modifier
                    .background(
                        ColorPokemonTypeMap[pokemonType]!!,
                        shape = RoundedCornerShape(4.dp)
                    )
                    .padding(top = 8.dp, bottom = 8.dp, start = 32.dp, end = 32.dp),
                text = pokemonType.uppercase(),
                color = ColorBackground,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 16.dp),
        text = "Height: ${pokemonDetails.getMetricHeight()}",
        color = ColorTextItems,
        style = MaterialTheme.typography.titleMedium
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 4.dp),
        text = "Weight: ${pokemonDetails.getMetricWeight()}",
        color = ColorTextItems,
        style = MaterialTheme.typography.titleMedium
    )
}