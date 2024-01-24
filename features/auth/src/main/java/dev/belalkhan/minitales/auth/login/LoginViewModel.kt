package dev.belalkhan.minitales.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belalkhan.minitales.auth.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
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

            LoginUiEvents.Login -> {
                login()
            }
            /* LoginUiEvents.ForgetPassword -> {

             }

             LoginUiEvents.SignUp -> {

             }*/
            else -> {

            }
        }
    }

    private fun login() = viewModelScope.launch {
        loginUseCase.invoke(_uiState.value.email, _uiState.value.password)
    }
}