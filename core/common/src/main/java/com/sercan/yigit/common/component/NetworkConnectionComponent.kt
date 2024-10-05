package com.sercan.yigit.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.sercan.yigit.common.R
import com.sercan.yigit.common.utils.ColorBackground
import com.sercan.yigit.common.utils.ColorTextItems

@Composable
fun NetworkConnectionComponent() {
    Box(
        modifier = Modifier
            .background(color = ColorBackground)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Bağlantı Sorunu :(",
                color = ColorTextItems,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
            )
            LottieAnimationComponent(
                animationFileName = R.raw.pikachu
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Oops! İnternet bağlantını kontrol et.",
                color = ColorTextItems,
                textAlign = TextAlign.Center,
                style = typography.titleMedium,
                fontSize = 24.sp,
            )
        }
    }
}