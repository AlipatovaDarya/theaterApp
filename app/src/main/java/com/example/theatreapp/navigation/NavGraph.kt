package com.example.theatreapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.theatreapp.view.AccountScreen
import com.example.theatreapp.view.BasketScreen
import com.example.theatreapp.view.MainScreen
import com.example.theatreapp.view.PerformanceScreen
import com.example.theatreapp.view.SeatSelectionScreen

@Composable
fun AppScreen(
    navController: NavHostController,
    padding: PaddingValues,
) {
    NavHost(
        modifier = Modifier.padding(paddingValues = padding),
        navController = navController,
        startDestination = MainDestinations.HOME_SCREEN,
        builder = {
            composable(route = MainDestinations.ACCOUNT_SCREEN) {
                AccountScreen(navController = navController)
            }
            composable(route = MainDestinations.HOME_SCREEN) {
                MainScreen(navController)
            }
            composable(route = MainDestinations.SHOPPING_CART_SCREEN) {
                BasketScreen(navController = navController)
            }
            composable(
                route = "${MainDestinations.SELECT_SEAT_SCREEN}/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.StringType }),
                ) {
                SeatSelectionScreen(navController)
            }
            composable(
                route = "${MainDestinations.PERFORMANCE_SCREEN}/{itemId}",
                arguments = listOf(navArgument("itemId") { type = NavType.StringType }),
                ) {
                PerformanceScreen(navController)
            }
        })
}

object MainDestinations {
    const val HOME_SCREEN = "homeScreen"
    const val SHOPPING_CART_SCREEN = "shoppingCartScreen"
    const val ACCOUNT_SCREEN = "accountScreen"
    const val SELECT_SEAT_SCREEN = "selectSeatScreen"
    const val PERFORMANCE_SCREEN = "performanceScreen"
}