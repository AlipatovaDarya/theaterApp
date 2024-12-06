package com.example.theatreapp

import com.example.theatreapp.models.BottomNavItemModel
import com.example.theatreapp.navigation.MainDestinations

object Constants {
    val BottomNavItems = listOf(
        BottomNavItemModel(
            label = "Корзина",
            icon = R.drawable.ic__calendar_,
            route = MainDestinations.SHOPPING_CART_SCREEN
        ),
        BottomNavItemModel(
            label = "Главная",
            icon = R.drawable.ic_home,
            route = MainDestinations.HOME_SCREEN

        ),
        BottomNavItemModel(
            label = "Аккаунт",
            icon = R.drawable.ic_account,
            route = MainDestinations.ACCOUNT_SCREEN
        ),

    )
}