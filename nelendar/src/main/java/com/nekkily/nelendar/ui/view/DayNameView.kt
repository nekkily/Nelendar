package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = dayOfWeekFontSize,
        fontFamily = dayOfWeekFontFamily,
        text = day.lowercase(LocaleDefault()),
        color = dayOfWeekColor,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}