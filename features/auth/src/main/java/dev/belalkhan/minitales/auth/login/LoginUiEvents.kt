package dev.belalkhan.minitales.auth.login

sealed class LoginUiEvents {
    data class EmailChanged(val email: String) : LoginUiEvents()
    data class PasswordChanged(val password: String) : LoginUiEvents()


    data object Login : LoginUiEvents()
    data object ForgetPassword : LoginUiEvents()
    data object SignUp : LoginUiEvents()
}
