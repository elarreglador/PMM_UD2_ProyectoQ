package com.elarreglador.ud2_09_q.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elarreglador.ud2_09_q.screens.LoginScreen

@Composable
fun Navegador() {
    val navController = rememberNavController()
    NavHost (navController = navController, startDestination = "login") {
        composable("login") { LoginScreen() }
    }
}