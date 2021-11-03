package com.example.wildhealthapp.android.utils

sealed class Screen(val route: String) {
    object SearchScreen : Screen("search_screen")
    object FoodDetailsScreen : Screen("food_details_screen")
    object FoodListScreen : Screen("food_list_screen")
}