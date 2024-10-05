package com.sercan.yigit.common.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sercan.yigit.common.R
import com.sercan.yigit.common.component.LottieAnimationComponent
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorTextItems
import com.sercan.yigit.network.util.StateHolder
import kotlinx.coroutines.flow.StateFlow

@Composable
fun <T> BaseComposableView(
    modifier: Modifier = Modifier,
    uiState: StateFlow<StateHolder<T>>
) {
    val state by uiState.collectAsState()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.isLoading) {
            Box(modifier = Modifier
                .background(color = ColorBackground).fillMaxSize(), contentAlignment = Alignment.Center) {
                LottieAnimationComponent(
                    animationFileName = R.raw.pokeball,
                    modifier = Modifier.size(110.dp)
                )
            }
        }
        if (state.error.isNotBlank()) {
            Box(modifier = Modifier
                .background(color = ColorBackground).fillMaxSize(), contentAlignment = Alignment.Center) {
                Column {
                    LottieAnimationComponent(
                        animationFileName = R.raw.bulbasaur,
                        modifier = Modifier.size(110.dp)
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Oops! Bir problem oluştu.",
                        color = ColorTextItems,
                        textAlign = TextAlign.Center,
                        style = typography.titleMedium,
                        fontSize = 26.sp,
                    )
                }
            }
        }
    }
}