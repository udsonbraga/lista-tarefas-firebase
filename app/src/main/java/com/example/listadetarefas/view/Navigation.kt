package com.example.listadetarefas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listatarefas.view.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("welcome") { WelcomeScreen(navController) }
        composable("lista") { ListaTarefasScreen() }
        composable("salvar") { SalvarTarefaScreen(navController) }
    }
}