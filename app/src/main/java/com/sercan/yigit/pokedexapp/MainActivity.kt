package com.sercan.yigit.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.base.BaseComposableView
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.pokedexapp.navigation.AppNavGraph
import com.sercan.yigit.pokedexapp.navigation.NavigationProvider
import com.sercan.yigit.pokedexapp.ui.theme.PokedexAppTheme
import com.sercan.yigit.pokemonlist.presentation.screen.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationProvider: NavigationProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                val connection by viewModel.isConnected.collectAsState()

                if (connection.not()) {
                    Box(modifier = Modifier
                        .background(color = ColorBackground)
                        .fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Oops! İnternet bağlantını kontrol et.",
                                color = ColorTextItems,
                                textAlign = TextAlign.Center,
                                style = typography.titleMedium
                            )
                        }
                    }
                } else {
                    val navController = rememberNavController()
                    App(navHostController = navController, navigationProvider)
                }
            }
        }
    }


    @Composable
    fun App(navHostController: NavHostController, navigationProvider: NavigationProvider) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(color = ColorBackground)

        Surface(
            modifier = Modifier
                .background(ColorBackground)
                .fillMaxSize(),
            color = ColorBackground
        ) {
            AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewBaseComposable() {

    }
}

