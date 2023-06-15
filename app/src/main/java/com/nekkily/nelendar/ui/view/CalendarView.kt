package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.ui.theme.NelendarTheme
import com.nekkily.nelendar.util.CalendarUtil
import com.nekkily.nelendar.util.DayModel
import java.util.*

@Composable
fun Calendar(
    firstDayOfWeek: FirstDayOfWeek,
    monthTextColor: Color,
    monthFontFamily: FontFamily,
    monthFontSize: TextUnit,
    dayOfMonthBackgroundColor: Color,
    dayOfMonthCurrentTextColor: Color,
    dayOfMonthOtherTextColor: Color,
    dayOfMonthFontFamily: FontFamily,
    dayOfMonthFontSize: TextUnit,
    dayOfWeekColor: Color,
    dayOfWeekFontFamily: FontFamily,
    dayOfWeekFontSize: TextUnit,
    dayOfMonthBackgroundShape: RoundedCornerShape,
    currentDayBackgroundColor: Color,
    selectedDayBackgroundColor: Color,
    calendarHorizontalPadding: Dp,
    calendarChildrenVerticalPadding: Dp,
    horizontalDaysPadding: Dp,
    verticalDaysPadding: Dp,
    onMonthChange: (Date) -> Unit,
    onDaySelected: (DayModel) -> Unit
) {
    NelendarTheme {
        val currentMonth = remember { mutableStateOf(CalendarUtil.generateMonthByIndex(0)) }
        val selectedDay = remember { mutableStateOf(DayModel(Date(), true)) }

        EndlessViewPager(
            contentView = { initialPage, pageIndex ->
                val monthIndex = pageIndex.minus(initialPage)
                val date = CalendarUtil.generateMonthByIndex(monthIndex)
                currentMonth.value = date

                Box {
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(calendarHorizontalPadding, 0.dp),
                            fontSize = monthFontSize,
                            fontFamily = monthFontFamily,
                            text = CalendarUtil.getMonthName(date),
                            color = monthTextColor
                        )

                        Spacer(modifier = Modifier.height(calendarChildrenVerticalPadding))
                        
                        CalendarMonthCard(
                            days = CalendarUtil.getCalendarDays(date, firstDayOfWeek),
                            dayOfWeekColor = dayOfWeekColor,
                            dayOfWeekFontFamily = dayOfWeekFontFamily,
                            dayOfWeekFontSize = dayOfWeekFontSize,
                            horizontalDaysPadding = horizontalDaysPadding,
                            verticalDaysPadding = verticalDaysPadding,
                            dayView = { day ->
                                Day(
                                    day = day,
                                    backgroundShape = dayOfMonthBackgroundShape,
                                    backgroundColor = dayOfMonthBackgroundColor,
                                    currentDayBackgroundColor = currentDayBackgroundColor,
                                    selectedDayBackgroundColor = selectedDayBackgroundColor,
                                    currentMonthTextColor = dayOfMonthCurrentTextColor,
                                    otherMonthTextColor = dayOfMonthOtherTextColor,
                                    fontFamily = dayOfMonthFontFamily,
                                    fontSize = dayOfMonthFontSize,
                                    selectedDay = selectedDay
                                ) {
                                    selectedDay.value = it
                                    onDaySelected(it)
                                }
                            }
                        )
                    }
                }
            },
            onPageChange = {
                onMonthChange(CalendarUtil.generateMonthByIndex(it))
            }
        )
    }
}