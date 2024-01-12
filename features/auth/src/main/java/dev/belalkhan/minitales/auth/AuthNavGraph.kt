package dev.belalkhan.minitales.auth

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import dev.belalkhan.minitales.auth.login.Login
import dev.belalkhan.minitales.auth.login.LoginScreen
import dev.belalkhan.minitales.auth.splash.SplashScreen

const val authRoute = "auth"

sealed class AuthRoute(val route: String) {
    data object Splash : AuthRoute("$authRoute/splash")
    data object Login : AuthRoute("$authRoute/login")
    data object SignUp : AuthRoute("$authRoute/signup")
}

fun NavGraphBuilder.authNavGraph(
    onAuthSuccessful: () -> Unit,
    navController: NavController
) {
    navigation(startDestination = AuthRoute.Splash.route, route = authRoute) {
        composable(AuthRoute.Splash.route) {
            SplashScreen()
            navController.navigate(AuthRoute.Login.route)
        }
        composable(AuthRoute.Login.route) {
            LoginScreen(viewModel())
        }
    }
}