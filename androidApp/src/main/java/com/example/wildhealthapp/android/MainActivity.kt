package com.example.wildhealthapp.android

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import com.example.wildhealthapp.android.ui.theme.WildHealthTheme
import com.example.wildhealthapp.android.viewmodel.FoodViewModel
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.example.wildhealthapp.android.utils.Navigation
import com.example.wildhealthapp.android.utils.Screen
import org.koin.core.component.KoinComponent


class MainActivity : ComponentActivity(), KoinComponent {

    private val viewModel: FoodViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WildHealthTheme {
                val lifecycleOwner = LocalLifecycleOwner.current
                val lifecycleAwareFoodFlow = remember(viewModel.foodStateFlow, lifecycleOwner) {
                    viewModel.foodStateFlow.flowWithLifecycle(lifecycleOwner.lifecycle)
                }
                val foodState by lifecycleAwareFoodFlow.collectAsState(viewModel.foodStateFlow.value)
                val navController = rememberNavController()

                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Navigation(navController, viewModel) {
                        viewModel.selectedFoodItem = it
                        navController.navigate(Screen.FoodDetailsScreen.route)
                    }
                }
                if (foodState.data?.isNotEmpty() == true && foodState.exception.isNullOrBlank()) {
                    navController.navigate(Screen.FoodListScreen.route)
                }
            }
        }
    }
}
