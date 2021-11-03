package com.example.wildhealthapp.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wildhealthapp.android.ui.theme.Dimens
import com.example.wildhealthapp.response.FoodDetails
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color

@Composable
fun FoodRow(foodDetails: FoodDetails, onItemClick: (FoodDetails) -> Unit) {
    Row(
        Modifier.clickable { onItemClick(foodDetails) }.padding(10.dp)
    ) {
        Text(foodDetails.shrtDesc, Modifier.weight(3F))
        Text(foodDetails.energKcal.toString(), Modifier.weight(1F))
    }
}

@Preview
@Composable
fun FoodRow_Preview() {
    Row(
        Modifier.padding(10.dp).background(Color.White)
    ) {
        Text("Cereal", Modifier.weight(3F))
        Text("50kcal", Modifier.weight(1F))
    }
}