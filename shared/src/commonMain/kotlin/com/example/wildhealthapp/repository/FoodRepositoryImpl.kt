package com.example.wildhealthapp.repository

import com.example.wildhealthapp.api.FoodApi
import com.example.wildhealthapp.response.FoodDetails
import com.example.wildhealthapp.utils.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class FoodRepositoryImpl : FoodRepository, KoinComponent {

    private val foodApi: FoodApi by inject()

    override suspend fun getDetailsForFoodItem(term: String): Flow<DataState<List<FoodDetails>>> =
        flow {
            emit(DataState<List<FoodDetails>>(loading = true))
            val resource = try {
                val response = foodApi.getFoodDetails(term)
                if (response.isEmpty()) {
                    DataState<List<FoodDetails>>(empty = true)
                } else {
                    DataState<List<FoodDetails>>(
                        response
                    )
                }
            } catch (ex: Exception) {
                println(ex.toString())
//                DataState<List<FoodDetails>>(exception = "Unable to get details for item.")
                DataState<List<FoodDetails>>(exception = ex.toString())
            }
            emit(resource)
        }.flowOn(Dispatchers.Default)


}