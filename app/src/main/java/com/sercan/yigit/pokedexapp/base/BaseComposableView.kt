package com.sercan.yigit.pokedexapp.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> BaseComposableView(
    title: String,
    modifier: Modifier = Modifier,
    viewModel: BaseViewModel,
    showToolbar: Boolean = true,
    successContent: @Composable (T) -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val isConnected by viewModel.isConnected.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showToolbar) {
            TopAppBar(
                title = { Text(text = title) },
                modifier = Modifier.fillMaxWidth(),
                colors = topAppBarColors(
                    containerColor = Color.White
                )
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isConnected) {
            Text(text = "Connected to the Internet", color = Color.Green)
        } else {
            Text(text = "No Internet Connection", color = Color.Red)
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }
            is UiState.Success<*> -> {
                successContent((uiState as UiState.Success<T>).data)
            }
            is UiState.Error -> {
                Text(text = (uiState as UiState.Error).message, color = Color.Red)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        content()
    }
}