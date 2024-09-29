package com.sercan.yigit.pokedexapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sercan.yigit.pokedexapp.base.BaseComposableView
import com.sercan.yigit.pokedexapp.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                SampleScreen()
            }
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

