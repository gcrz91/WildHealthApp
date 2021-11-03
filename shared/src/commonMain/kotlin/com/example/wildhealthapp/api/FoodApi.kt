package com.example.wildhealthapp.api

import com.example.wildhealthapp.BuildKonfig
import com.example.wildhealthapp.response.FoodDetails
import com.example.wildhealthapp.utils.Constants
import io.ktor.client.request.*

internal class FoodApi(private val ktorApi: KtorApi): KtorApi by ktorApi {

    suspend fun getFoodDetails(term: String): List<FoodDetails> = client.get {
        apiUrl("api/search")
        parameter("keyword", term)
    }

}