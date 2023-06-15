package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.util.CalendarUtil
import com.nekkily.nelendar.util.CalendarUtil.toDateMidnight
import com.nekkily.nelendar.util.DayModel
import java.util.*

@Composable
fun Day(
    day: DayModel,
    backgroundShape: RoundedCornerShape,
    backgroundColor: Color,
    currentDayBackgroundColor: Color,
    selectedDayBackgroundColor: Color,
    currentMonthTextColor: Color,
    otherMonthTextColor: Color,
    fontFamily: FontFamily,
    fontSize: TextUnit,
    selectedDay: MutableState<DayModel>,
    onItemClick: (DayModel) -> Unit
) {
    val dayOfMonth = CalendarUtil.getDayOfMonth(day.date)

    val isDayCurrent = toDateMidnight(Date()) == toDateMidnight(day.date)
    val isSelectedDay = selectedDay.value == day

    Card(
        modifier = Modifier
            .size(40.dp, 64.dp)
            .clickable {
                onItemClick(day)
            },
        shape = backgroundShape,
        colors = CardDefaults.cardColors(
            containerColor = if (isDayCurrent) {
                currentDayBackgroundColor
            } else if (isSelectedDay) {
                selectedDayBackgroundColor
            } else {
                backgroundColor
            },
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