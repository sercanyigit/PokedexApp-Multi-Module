package com.sercan.yigit.pokemondetails.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.sercan.yigit.common.base.BaseComposableView
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorPastel3
import com.sercan.yigit.common.utils.ColorPokemonTypeMap
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.common.utils.getPokemonImage
import com.sercan.yigit.common.utils.titleCase
import com.sercan.yigit.pokemondetails.presentation.component.LoadingAnimation

@Composable
fun PokemonDetailsScreen(
    id: String,
    navController: NavController
) {

    val viewModel = hiltViewModel<PokemonDetailsViewModel>()
    val result by viewModel.pokemonDetails.collectAsState()

    Scaffold(modifier = Modifier.background(ColorBackground).fillMaxSize()) { screen ->
        Log.e("TAG", "Pokemon Details Screen: $screen")

        BaseComposableView(uiState = viewModel.pokemonDetails)

        result.data?.let {
            Column(
                modifier = Modifier
                    .background(ColorBackground)
                    .padding(top = 32.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Icon(
                        modifier = Modifier
                            .padding(start = 32.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                        imageVector = Icons.Default.ArrowBack,
                        tint = ColorTextItems,
                        contentDescription = null
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.name.titleCase(),
                            color = ColorTextItems,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = it.id.toString().padStart(3, '0'),
                            color = ColorTextItems,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp)
                        .padding(32.dp),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(ColorPastel3)
                    ) {
                        SubcomposeAsyncImage(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(64.dp),
                            model = getPokemonImage(id),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            loading = { LoadingAnimation() }
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp)
                ) {
                    for (i in 0 until it.type.size) {
                        val pokemonType = it.type[i] ?: ""
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
                    text = "Height: ${it.getMetricHeight()}",
                    color = ColorTextItems,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp, top = 4.dp),
                    text = "Weight: ${it.getMetricWeight()}",
                    color = ColorTextItems,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}