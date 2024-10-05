package com.sercan.yigit.common.component
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun LottieAnimationComponent(
    animationFileName: Int,
    loop: Boolean = true,
    modifier: Modifier = Modifier
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(animationFileName))
    LottieAnimation(
        composition,
        iterations = if (loop) LottieConstants.IterateForever else 1,
        modifier = modifier
    )
}