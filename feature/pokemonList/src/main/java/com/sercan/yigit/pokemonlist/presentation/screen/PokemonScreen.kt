package com.sercan.yigit.pokemonlist.presentation.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sercan.yigit.common.R
import com.sercan.yigit.common.base.BaseComposableView
import com.sercan.yigit.common.component.LottieAnimationComponent
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorTextFieldContainerDefault
import com.sercan.yigit.common.utils.ColorTextFieldText
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.common.utils.ColorTextTitle
import com.sercan.yigit.pokemonlist.presentation.component.PokemonListItem

@Composable
fun PokemonScreen(navController: NavController) {

    val viewModel = hiltViewModel<PokemonViewModel>()
    val result by viewModel.pokemonList.collectAsState()
    val query = viewModel.query.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Scaffold(
        modifier = Modifier
            .background(color = ColorBackground)
            .padding(top = 8.dp)
            .noRippleClickable {
                keyboardController?.hide()
            },
        topBar = {
            Column(
                modifier = Modifier
                    .background(color = ColorBackground)
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp)
            ) {
                Text(
                    text = "Pokédex",
                    color = ColorTextTitle,
                    modifier = Modifier
                        .padding(top = 20.dp),
                    fontWeight = FontWeight.Bold,
                    style = typography.headlineMedium
                )
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp)
                ) {
                    TextField(
                        modifier = Modifier.weight(4f),
                        value = query.value,
                        onValueChange = {
                            viewModel.setQuery(it)
                        },
                        colors = TextFieldDefaults.colors(
                            unfocusedTextColor = ColorTextFieldText,
                            focusedContainerColor = ColorTextFieldContainerDefault,
                            unfocusedContainerColor = ColorTextFieldContainerDefault,
                            disabledContainerColor = ColorTextFieldContainerDefault,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                        ),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        },
                        placeholder = { Text(text = "Arama yap...") }
                    )
                }
            }
        }) { screen ->
        Log.e("TAG", "PokemonScreen: $screen")

        BaseComposableView(uiState = viewModel.pokemonList)
        result.data?.let {
            if (it.isEmpty()) {
                Box(modifier = Modifier.background(color = ColorBackground).fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column {
                        LottieAnimationComponent(
                            animationFileName = R.raw.bulbasaur
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Pokemon Bulunamadı",
                            color = ColorTextItems,
                            textAlign = TextAlign.Center,
                            style = typography.titleMedium
                        )
                    }
                }
            } else {
                LazyVerticalGrid(
                    modifier = Modifier
                        .background(color = ColorBackground)
                        .padding(top = 180.dp, start = 16.dp, end = 16.dp),
                    columns = GridCells.Fixed(2),
                    content = {
                        itemsIndexed(it) { index, pokemon ->
                            val pokemonNumber = pokemon.id
                            PokemonListItem(navController, index, pokemonNumber, pokemon)
                        }
                    }
                )
            }
        }
    }
}

@SuppressLint("ModifierFactoryUnreferencedReceiver")
fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}