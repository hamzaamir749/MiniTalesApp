package dev.belalkhan.minitales.theme.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import dev.belalkhan.minitales.theme.MiniTalesTheme

@Composable
fun AppBar(
    title: String,
    navIcon: ImageVector? = null,
    navAction: () -> Unit = {},
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        navigationIcon = {
            navIcon?.let {
                IconButton(onClick = { navAction() }) {
                    Icon(navIcon, contentDescription = "Nav Icon")
                }
            }
        },
        title = {
            Text(text = title)
        },
    )
}

@Composable
@MiniTalesPreview
fun AppPreview() {
    MiniTalesTheme {
        Surface {
            AppBar(title = "Mini Tales", navIcon = Icons.Filled.ArrowBack)
        }
    }
}
