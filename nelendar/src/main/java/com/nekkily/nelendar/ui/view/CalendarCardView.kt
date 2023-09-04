package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.model.params.CalendarParams
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.util.CalendarUtil
import java.util.Date

@Composable
fun CalendarCard(
    date: Date,
    params: CalendarParams
) {
    params.apply {
        val daysNames = CalendarUtil.getWeekDaysNames(firstDayOfWeek)

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth()
                .padding(26.dp, 0.dp),
            columns = GridCells.Fixed(DAYS_IN_WEEK),
            horizontalArrangement = Arrangement.spacedBy(horizontalDaysPadding),
            verticalArrangement = Arrangement.spacedBy(verticalDaysPadding)
        ) {
            if (calendarState == CalendarState.MONTH) {
                items(daysNames.size) {
                    DayName(
                        day = daysNames[it],
                        dayOfWeekColor = dayParams.dayOfWeekColor,
                        dayOfWeekFontFamily = dayParams.dayOfWeekFontFamily,
                        dayOfWeekFontSize = dayParams.dayOfWeekFontSize
                    )
                }
                val days = CalendarUtil.getDaysInMonth(date)
                items(days.size) {
                    Box {
                        MonthDay(
                            day = days[it],
                            selectedDay = selectedDay,
                            params = dayParams
                        ) {
                            selectedDay.value = it
                            dayParams.onDaySelected(it)
                        }
                    }
                }
            } else {
                val days = CalendarUtil.getDaysInWeek(date)
                items(days.size) {
                    Box {
                        WeekDay(
                            day = days[it],
                            dayName = daysNames[it],
                            selectedDay = selectedDay,
                            params = dayParams
                        ) {
                            selectedDay.value = it
                            dayParams.onDaySelected(it)
                        }
                    }
                }
            }
        }
    }
}