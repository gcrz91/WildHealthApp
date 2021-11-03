package com.example.wildhealthapp.android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wildhealthapp.response.FoodDetails
import com.example.wildhealthapp.repository.FoodRepository
import com.example.wildhealthapp.utils.DataState
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class FoodViewModel : ViewModel(), KoinComponent {

    private val repository: FoodRepository by inject()

    private val _foodStateFlow: MutableStateFlow<DataState<List<FoodDetails>>> = MutableStateFlow(
        DataState()
    )
    val foodStateFlow: StateFlow<DataState<List<FoodDetails>>> = _foodStateFlow

    private var _keyword: MutableStateFlow<String> = MutableStateFlow("")
    val keyword: StateFlow<String> = _keyword

    var selectedFoodItem: FoodDetails? = null

    @OptIn(FlowPreview::class)
    fun getFoodDetailsForKeyword() {
        if (keyword.value.isBlank()) {
            _foodStateFlow.value = _foodStateFlow.value.copy(exception = "Please Enter a valid input.")
        }
        viewModelScope.launch {
            repository.getDetailsForFoodItem(keyword.value).collect { dataState ->
                if (dataState.loading) {
                    _foodStateFlow.value = DataState(loading = true)
                } else {
                    _foodStateFlow.value = dataState
                }
            }
        }
    }

    fun updateKeyword(keyword: String) {
        _keyword.value = keyword
    }
}