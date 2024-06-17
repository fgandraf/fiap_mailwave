package br.com.mailwave

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.mailwave.screens.HomeScreen
import br.com.mailwave.screens.MessageScreen
import br.com.mailwave.screens.SplashScreen
import br.com.mailwave.ui.theme.MailWaveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MailWaveTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "splash"
                    ) {
                        composable(route = "splash") { SplashScreen(navController = navController) }
                        composable(route = "home") { HomeScreen(navController = navController) }
                        composable(route = "message/create") { MessageScreen(navController = navController) }
                        composable(route = "message/read") { MessageScreen(navController = navController) }
                    }

                }
            }
        }
    }
}
