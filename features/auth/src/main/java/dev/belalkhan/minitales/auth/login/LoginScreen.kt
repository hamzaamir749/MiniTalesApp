package dev.belalkhan.minitales.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.belalkhan.minitales.auth.R
import dev.belalkhan.minitales.theme.MiniTalesTheme
import dev.belalkhan.minitales.theme.components.AppTextField
import dev.belalkhan.minitales.theme.components.MiniTalesPreview

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    Login(uiState = uiState.value, onEvents = { event ->
        viewModel.onEvent(event)
    })
}

@Composable
fun Login(
    uiState: LoginUiState,
    onEvents: (LoginUiEvents) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Icon(
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(top = 42.dp, bottom = 32.dp),
            painter = painterResource(id = R.drawable.mini_tales),
            contentDescription = "App logo"
        )

        AppTextField(
            value = uiState.email,
            label = R.string.email,
            hint = "Yourname@domain.com",
            leadingIcon = Icons.Filled.Email,
            imeAction = ImeAction.Next,
            onValueChanged = { email ->
                onEvents(LoginUiEvents.EmailChanged(email))
            })

        AppTextField(
            value = uiState.password,
            label = R.string.password,
            hint = "Password",
            leadingIcon = Icons.Filled.Lock,
            imeAction = ImeAction.Done,
            isPasswordField = true,
            onValueChanged = { password ->
                onEvents(LoginUiEvents.PasswordChanged(password))
            })

        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(id = R.string.forgot_password),
                    style = MaterialTheme.typography
                        .bodyLarge
                )
                Text(
                    text = stringResource(id = R.string.click_here_to_reset),
                    style = MaterialTheme.typography
                        .bodySmall
                )
            }
            Button(modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp), onClick = {onEvents.invoke(LoginUiEvents.Login) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_forward),
                    contentDescription = "App logo"
                )
            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .clickable {

                },
            text = stringResource(id = R.string.dont_have_account),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography
                .bodyLarge
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .clickable {

                },
            text = stringResource(id = R.string.agree_terms),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography
                .bodyMedium
        )
    }
}

@Composable
@MiniTalesPreview
fun AppPreview() {
    MiniTalesTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Login(
                uiState = LoginUiState(),
                onEvents = {}
            )
        }
    }
}
