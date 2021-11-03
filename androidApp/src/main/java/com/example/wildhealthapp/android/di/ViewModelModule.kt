package com.example.wildhealthapp.android.di

import com.example.wildhealthapp.android.viewmodel.FoodViewModel
import org.koin.dsl.module

val viewModelModule = module {
    factory { FoodViewModel() }
}