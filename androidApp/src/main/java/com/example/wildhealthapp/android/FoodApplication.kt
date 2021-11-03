package com.example.wildhealthapp.android

import android.app.Application
import android.content.Context
import com.example.wildhealthapp.android.di.viewModelModule
import com.example.wildhealthapp.di.initKoin
import com.example.wildhealthapp.android.viewmodel.FoodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class FoodApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                viewModelModule
                single<Context> { this@FoodApplication }
                viewModel { FoodViewModel() }
            }
        )
    }
}
