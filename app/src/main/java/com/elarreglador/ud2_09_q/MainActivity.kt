package com.elarreglador.ud2_09_q

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.elarreglador.ud2_09_q.Navigation.Navegador
import com.elarreglador.ud2_09_q.screens.LoginScreen
import com.elarreglador.ud2_09_q.ui.theme.UD2_09_QTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UD2_09_QTheme {
                Navegador()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD2_09_QTheme{
        LoginScreen()
    }
}