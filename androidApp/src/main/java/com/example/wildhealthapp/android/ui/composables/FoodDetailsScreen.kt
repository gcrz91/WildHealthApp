package com.example.wildhealthapp.android.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.wildhealthapp.response.FoodDetails
import androidx.compose.material.Text
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FoodDetailsScreen(
    foodDetails: FoodDetails?
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Short Description: ${foodDetails?.shrtDesc}")
            Text("Water: ${foodDetails?.water}")
            Text("Energy Kcal: ${foodDetails?.energKcal}")
            Text("Protein: ${foodDetails?.protein}")
            Text("Carbohydrates: ${foodDetails?.carbohydrt}")
            Text("Sugar Total: ${foodDetails?.sugarTot}")
            Text("Fiber: ${foodDetails?.fiberTd}")
        }
    }
}

@Preview
@Composable
fun FoodDetailsScreen_Preview() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Short Description: Apple")
        Text("Water: water")
        Text("Energy Kcal: 75")
        Text("Protein: 90")
        Text("Carbohydrates: 75")
        Text("Sugar Total: 45")
        Text("Fiber: 76")
    }
}