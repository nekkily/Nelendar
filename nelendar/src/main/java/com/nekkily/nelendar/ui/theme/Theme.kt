package com.nekkily.nelendar.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun NelendarTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        shapes = Shapes,
        content = content
    )
}