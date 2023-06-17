package com.nekkily.nelendar.ui.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.nekkily.nelendar.util.LocaleDefault

@Composable
fun DayName(
    day: String,
    dayOfWeekColor: Color,
    dayOfWeekFontFamily: FontFamily,
    dayOfWeekFontSize: TextUnit
) {
    Text(
        textAlign = TextAlign.Center,
        fontSize = dayOfWeekFontSize,
        fontFamily = dayOfWeekFontFamily,
        text = day.lowercase(LocaleDefault.get()),
        color = dayOfWeekColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}