package com.sercan.yigit.pokemonlist.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.sercan.yigit.common.component.LoadingAnimation
import com.sercan.yigit.common.utils.ColorLazyGridItem
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.common.utils.getPokemonImage
import com.sercan.yigit.common.utils.titleCase
import com.sercan.yigit.pokemonlist.domain.model.Pokemon

@Composable
fun PokemonListItem(
    navController: NavController,
    index: Int,
    pokemonNumber: String,
    pokemon: Pokemon
) {
    Card(
        modifier = Modifier
            .height(212.dp)
            .padding(8.dp)
            .clickable {
                navController.navigate("pokemon_details/${pokemonNumber}")
            },
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(ColorLazyGridItem[index % ColorLazyGridItem.size])
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp,
                        start = 20.dp,
                        end = 20.dp
                    )
                    .fillMaxWidth()
                    .height(130.dp),
                alignment = Alignment.Center,
                model = getPokemonImage(pokemonNumber),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                loading = { LoadingAnimation() }
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 12.dp,
                        end = 12.dp
                    ),
                text = pokemon.name.titleCase(),
                maxLines = 1,
                color = ColorTextItems,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = typography.bodyLarge
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 12.dp,
                        end = 12.dp
                    ),
                text = pokemonNumber.padStart(3, '0'),
                maxLines = 1,
                color = ColorTextItems,
                textAlign = TextAlign.Center,
                style = typography.bodyMedium
            )
        }
    }
}