package com.example.app_firebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.app_firebase.ui.theme.AppfirebaseTheme
import com.example.app_firebase.views.LoginScreen
import com.example.app_firebase.views.RegisterScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppfirebaseTheme {
                AppNavigation()
            }
        }
    }
}
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onNavigateToHome = { navController.navigate("home") },
                onNavigateToRegister = { navController.navigate("register") },
            )
        }
        composable("register") {
            RegisterScreen(
                onNavigateBackToLogin = { navController.popBackStack() }
            )
        }
        composable("home") {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Text("Welcome to the Home Screen!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppfirebaseTheme {
        AppNavigation()
    }
}

