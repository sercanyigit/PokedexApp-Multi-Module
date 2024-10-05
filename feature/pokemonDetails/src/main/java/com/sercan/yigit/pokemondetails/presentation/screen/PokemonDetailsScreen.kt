package com.sercan.yigit.pokemondetails.presentation.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.sercan.yigit.common.base.BaseComposableView
import com.sercan.yigit.common.component.LoadingAnimation
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorPastel3
import com.sercan.yigit.common.utils.getPokemonImage
import com.sercan.yigit.pokemondetails.presentation.component.PokemonDetailsTopBarComponent
import com.sercan.yigit.pokemondetails.presentation.component.PokemonTypeComponent

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
                PokemonDetailsTopBarComponent(navController = navController, pokemonDetails = it)

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

                PokemonTypeComponent(pokemonDetails = it)
            }
        }
    }
}