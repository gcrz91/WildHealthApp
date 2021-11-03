package com.example.wildhealthapp.di

import com.example.wildhealthapp.api.FoodApi
import com.example.wildhealthapp.api.KtorApi
import com.example.wildhealthapp.api.KtorApiImpl
import org.koin.dsl.module

val apiModule = module {
    single<KtorApi> { KtorApiImpl() }
    factory { FoodApi(get()) }
}