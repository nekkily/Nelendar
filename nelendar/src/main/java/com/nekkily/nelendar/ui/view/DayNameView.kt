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
import com.nekkily.nelendar.util.AppLocale

/**
 * Day of week name composable view.
 *
 * @param day [String] displayed name.
 * @param color [Color] to apply to the text.
 * @param fontFamily [FontFamily] font family of text.
 * @param fontSize [TextUnit] font size of text.
 */
@Composable
fun DayName(
    day: String,
    color: Color,
    fontFamily: FontFamily,
    fontSize: TextUnit
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = fontSize,
        fontFamily = fontFamily,
        text = day.lowercase(AppLocale().invoke()),
        color = color,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}