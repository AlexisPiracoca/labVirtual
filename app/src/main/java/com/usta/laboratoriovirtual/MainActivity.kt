package com.usta.laboratoriovirtual

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.usta.laboratoriovirtual.login.LoginScreen
import com.usta.laboratoriovirtual.ui.theme.LaboratorioVirtualTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            LaboratorioVirtualTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFDEFEFD)
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LaboratorioVirtualTheme {
        LoginScreen()
    }
}