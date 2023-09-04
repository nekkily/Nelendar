package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.model.params.DayParams
import com.nekkily.nelendar.util.CalendarUtil
import com.nekkily.nelendar.util.CalendarUtil.toDateMidnight
import java.util.*

@Composable
fun MonthDay(
    day: DayModel,
    selectedDay: MutableState<DayModel>,
    params: DayParams,
    onItemClick: (DayModel) -> Unit
) {
    params.apply {
        DayCard(
            height = 64.dp,
            day = day,
            backgroundShape = dayOfMonthBackgroundShape,
            backgroundColor = dayOfMonthBackgroundColor,
            currentDayBackgroundColor = currentDayBackgroundColor,
            selectedDayBackgroundColor = selectedDayBackgroundColor,
            selectedDay = selectedDay,
            onItemClick = onItemClick
        ) {
            DayText(
                day,
                dayOfMonthFontFamily,
                dayOfMonthFontSize,
                if (day.isCurrentMonth) {
                    dayOfMonthCurrentTextColor
                } else {
                    dayOfMonthOtherTextColor
                }
            )
        }
    }
}

@Composable
fun WeekDay(
    day: DayModel,
    dayName: String,
    selectedDay: MutableState<DayModel>,
    params: DayParams,
    onItemClick: (DayModel) -> Unit
) {
    params.apply {
        DayCard(
            height = 86.dp,
            day = day,
            backgroundShape = dayOfMonthBackgroundShape,
            backgroundColor = dayOfMonthBackgroundColor,
            currentDayBackgroundColor = currentDayBackgroundColor,
            selectedDayBackgroundColor = selectedDayBackgroundColor,
            selectedDay = selectedDay,
            onItemClick = onItemClick
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                ) {
                    DayName(
                        day = dayName,
                        dayOfWeekColor = dayOfWeekColor,
                        dayOfWeekFontFamily = dayOfWeekFontFamily,
                        dayOfWeekFontSize = dayOfWeekFontSize
                    )
                }
                DayText(
                    day,
                    dayOfMonthFontFamily,
                    dayOfMonthFontSize,
                    if (day.isCurrentMonth) {
                        dayOfMonthCurrentTextColor
                    } else {
                        dayOfMonthOtherTextColor
                    }
                )
            }
        }
    }
}

@Composable
fun DayCard(
    height: Dp,
    day: DayModel,
    backgroundShape: RoundedCornerShape,
    backgroundColor: Color,
    currentDayBackgroundColor: Color,
    selectedDayBackgroundColor: Color,
    selectedDay: MutableState<DayModel>,
    onItemClick: (DayModel) -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    val isDayCurrent = toDateMidnight(Date()) == toDateMidnight(day.date)
    val isSelectedDay = toDateMidnight(selectedDay.value.date) == toDateMidnight(day.date)

    Card(
        modifier = Modifier
            .size(40.dp, height)
            .clickable {
                onItemClick(day)
            },
        shape = backgroundShape,
        colors = CardDefaults.cardColors(
            containerColor = if (isSelectedDay) {
                selectedDayBackgroundColor
            } else if (isDayCurrent) {
                currentDayBackgroundColor
            } else {
                backgroundColor
            }
        )
    ) {
        content()
    }
}

@Composable
fun ColumnScope.DayText(
    day: DayModel,
    fontFamily: FontFamily,
    fontSize: TextUnit,
    textColor: Color
) {
    val dayOfMonth = CalendarUtil.getDayOfMonth(day.date)

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
                color = textColor
            )
        )
    }
}