package com.example.wildhealthapp.android.ui.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavHostController
import com.example.wildhealthapp.android.viewmodel.FoodViewModel
import com.example.wildhealthapp.response.FoodDetails

@Composable
fun FoodListScreen(
    viewModel: FoodViewModel,
    onClick: (FoodDetails) -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareFoodFlow = remember(viewModel.foodStateFlow, lifecycleOwner) {
        viewModel.foodStateFlow.flowWithLifecycle(lifecycleOwner.lifecycle)
    }
    val foodState by lifecycleAwareFoodFlow.collectAsState(viewModel.foodStateFlow.value)

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        if (foodState.empty) {
            EmptyScreen()
        }
        val data = foodState.data
        if (data != null) {
            FoodList(data, onClick)
        }
        val exception = foodState.exception
        if (exception != null) {
            ErrorScreen(exception)
        }
    }

}