package com.example.wildhealthapp.android.utils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.wildhealthapp.android.ui.composables.FoodDetailsScreen
import com.example.wildhealthapp.android.ui.composables.FoodListScreen
import com.example.wildhealthapp.android.ui.composables.SearchScreen
import com.example.wildhealthapp.android.viewmodel.FoodViewModel
import com.example.wildhealthapp.response.FoodDetails

@Composable
fun Navigation(
    navController: NavHostController,
    viewModel: FoodViewModel,
    onFoodClickListener: (FoodDetails) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SearchScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SearchScreen.route) {
            SearchScreen(viewModel)
        }
        composable(Screen.FoodListScreen.route) {
            FoodListScreen(
                viewModel,
                onFoodClickListener
            )
        }
        composable(Screen.FoodDetailsScreen.route) {
            FoodDetailsScreen(foodDetails = viewModel.selectedFoodItem)
        }
    }
}