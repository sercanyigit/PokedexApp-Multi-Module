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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.pokedexapp.navigation.AppNavHost
import com.sercan.yigit.pokedexapp.ui.theme.PokedexAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokedexAppTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                val connection by viewModel.isConnected.collectAsState()

                if (connection.not()) {
                    Box(
                        modifier = Modifier
                            .background(color = ColorBackground)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
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
                    AppNavHost()
                }
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun PreviewBaseComposable() {

    }
}

