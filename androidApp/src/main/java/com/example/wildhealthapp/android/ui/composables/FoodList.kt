package com.example.wildhealthapp.android.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import com.example.wildhealthapp.response.FoodDetails

@Composable
fun FoodList(
    foodDetailsList: List<FoodDetails>,
    onItemClick: (FoodDetails) -> Unit
) {
    LazyColumn {
        items(foodDetailsList) { details ->
            FoodRow(details) {
                onItemClick(it)
            }
            Divider()
        }
    }
}