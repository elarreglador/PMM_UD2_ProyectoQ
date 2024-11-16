package com.elarreglador.ud2_09_q.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elarreglador.ud2_09_q.screens.LoginScreen
import com.elarreglador.ud2_09_q.screens.OrigenScreen

@Composable
fun Navegador() {
    val navController = rememberNavController()
    NavHost (navController = navController, startDestination = "LoginScreen") {
        composable("LoginScreen") { LoginScreen(navController) }
        composable("OrigenScreen") { OrigenScreen(navController) }
    }
}