package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.util.CalendarUtil
import com.nekkily.nelendar.util.Day


@Composable
fun Day(
    day: Day,
    backgroundShape: RoundedCornerShape,
    backgroundColor: Color,
    currentMonthTextColor: Color,
    otherMonthTextColor: Color,
    fontFamily: FontFamily,
    fontSize: TextUnit
) {
    val dayOfMonth = CalendarUtil.getDayOfMonth(day.date)

    Card(
        modifier = Modifier
            .size(40.dp, 64.dp),
        shape = backgroundShape,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        )
    ) {
        Box(
            modifier = Modifier
                .size(30.dp, 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxSize(),
                text = dayOfMonth,
                fontFamily = fontFamily,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = fontSize,
                    color = if (day.isCurrentMonth) {
                        currentMonthTextColor
                    } else {
                        otherMonthTextColor
                    }
                )
            )
        }
    }
}