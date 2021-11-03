package com.example.wildhealthapp.repository

import com.example.wildhealthapp.response.FoodDetails
import com.example.wildhealthapp.utils.DataState
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

    suspend fun getDetailsForFoodItem(term: String) : Flow<DataState<List<FoodDetails>>>

}