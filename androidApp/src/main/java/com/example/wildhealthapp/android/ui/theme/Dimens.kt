package com.example.wildhealthapp.android.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

internal val localDimens = staticCompositionLocalOf { Dimens() }

data class Dimens(
    val itemHeight: Dp = 56.dp,
    val itemPadding: Dp = 10.dp
)