package com.app.tiktok.ui


import TikTokScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.tiktok.ui.login.LoginScreen
@Composable
fun NavGraph(startDestination: String = "login") {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("home") {
            TikTokScreen(navController = navController)
        }
    }
}