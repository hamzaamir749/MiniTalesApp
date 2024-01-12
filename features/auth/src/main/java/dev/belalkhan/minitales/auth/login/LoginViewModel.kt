package dev.belalkhan.minitales.auth.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel() : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState


    fun onEvent(uiEvents: LoginUiEvents) {
        when (uiEvents) {
            is LoginUiEvents.EmailChanged -> {
                _uiState.value = _uiState.value.copy(email = uiEvents.email)
            }

            is LoginUiEvents.PasswordChanged -> {
                _uiState.value = _uiState.value.copy(password = uiEvents.password)
            }
            /* LoginUiEvents.ForgetPassword -> {

             }
             LoginUiEvents.Login -> {

             }
             LoginUiEvents.SignUp -> {

             }*/
            else -> {

            }
        }
    }
}