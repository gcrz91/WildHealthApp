package com.example.wildhealthapp.di

import com.example.wildhealthapp.repository.FoodRepository
import com.example.wildhealthapp.repository.FoodRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<FoodRepository> { FoodRepositoryImpl() }
}