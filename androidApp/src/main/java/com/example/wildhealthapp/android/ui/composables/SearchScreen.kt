package com.example.wildhealthapp.android.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.flowWithLifecycle
import androidx.navigation.NavController
import com.example.wildhealthapp.android.utils.Screen
import com.example.wildhealthapp.android.viewmodel.FoodViewModel

@Composable
fun SearchScreen(
    viewModel: FoodViewModel
) {

    val lifecycleOwner = LocalLifecycleOwner.current
    val lifecycleAwareFoodFlow = remember(viewModel.foodStateFlow, lifecycleOwner) {
        viewModel.foodStateFlow.flowWithLifecycle(lifecycleOwner.lifecycle)
    }
    val foodState by lifecycleAwareFoodFlow.collectAsState(viewModel.foodStateFlow.value)

    val lifecycleKeywordFlow = remember(viewModel.keyword, lifecycleOwner) {
        viewModel.keyword.flowWithLifecycle(lifecycleOwner.lifecycle)
    }

    val keywordState by lifecycleKeywordFlow.collectAsState(viewModel.keyword.value)

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            StandardTextField(
                text = keywordState,
                onValueChange = {
                    viewModel.updateKeyword(it)
                },
                hint = "Enter your favorite food.",
                keyboardType = KeyboardType.Text,
                error = viewModel.foodStateFlow.value.exception ?: ""
            )
            Button(
                onClick = {
                    viewModel.getFoodDetailsForKeyword()
                }
            ) {
                Text(
                    text = "Search",
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }

        if (foodState.loading) {
            Dialog(
                onDismissRequest = {},
                properties = DialogProperties(dismissOnClickOutside = false)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                ) {
                    CircularProgressIndicator()
                }

            }
        }
    }
}