package dev.belalkhan.minitales.auth.splash

import android.graphics.drawable.Icon
import android.window.SplashScreen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dev.belalkhan.minitales.auth.R
import dev.belalkhan.minitales.theme.MiniTalesTheme
import dev.belalkhan.minitales.theme.components.MiniTalesPreview

@Composable
fun SplashScreen() {
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.mini_tales),
            contentDescription = "App logo"
        )
    }
}

@Composable
@MiniTalesPreview
fun AppPreview() {
    MiniTalesTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Splash()
        }
    }
}
