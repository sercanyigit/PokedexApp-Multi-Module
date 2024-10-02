package com.sercan.yigit.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.pokedexapp.base.BaseComposableView
import com.sercan.yigit.pokedexapp.navigation.AppNavGraph
import com.sercan.yigit.pokedexapp.navigation.NavigationProvider
import com.sercan.yigit.pokedexapp.ui.theme.PokedexAppTheme
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
                val navController = rememberNavController()
                App(navHostController = navController, navigationProvider)
            }
        }
    }


    @Composable
    fun App(navHostController: NavHostController, navigationProvider: NavigationProvider) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(color = ColorBackground)

        Surface(
            modifier = Modifier.background(ColorBackground).fillMaxSize(),
            color = ColorBackground
        ) {
            AppNavGraph(navController = navHostController, navigationProvider = navigationProvider)
        }
    }


    @Composable
    fun SampleScreen() {
        val viewModel = hiltViewModel<MainViewModel>()
        BaseComposableView (
            title = "Pokedex",
            viewModel = viewModel,
            showToolbar = true,
            successContent = { data: String ->
                Text(text = "Success: $data", color = Color.Green)
            }
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Try Again")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewBaseComposable() {
        SampleScreen()
    }
}

