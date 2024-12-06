package com.example.theatreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.theatreapp.navigation.AppScreen
import com.example.theatreapp.ui.theme.TheatreAppTheme
import com.example.theatreapp.view.BottomNavigationBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val database = TheatreDatabase(this)
        /*database.insertData("Example", 10)
        val data = database.getData()*/

        enableEdgeToEdge()

        setContent {
            TheatreAppTheme {
                val navController: NavHostController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController = navController) }
                ) { innerPadding ->
                    AppScreen(navController, innerPadding)
                }
            }
        }
    }
}
