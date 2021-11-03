package com.example.wildhealthapp.utils

/**
 * Wrapper class to handle events on background processes
 */
data class DataState<out T>(
    val data: T? = null,
    val exception: String? = null,
    val empty: Boolean = false,
    val loading: Boolean = false
)
