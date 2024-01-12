package dev.belalkhan.minitales

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.belalkhan.minitales.auth.authNavGraph
import dev.belalkhan.minitales.auth.authRoute

@Composable
fun MiniTalesNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = authRoute) {
        authNavGraph(
            navController = navHostController,
            onAuthSuccessful = {

            }
        )
    }
}