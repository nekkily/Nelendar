package com.nekkily.nelendar.ui.view

import android.provider.SyncStateContract.Constants
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.ui.CalendarState
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
    calendarState: CalendarState,
    onMonthChange: (Date) -> Unit,
    onDaySelected: (DayModel) -> Unit
) {
    NelendarTheme {

        EndlessViewPager(
            contentView = { initialPage, pageIndex ->
                val index = pageIndex.minus(initialPage)
                val date = if (calendarState == CalendarState.MONTH) {
                    CalendarUtil.generateMonthByIndex(index)
                } else {
                    CalendarUtil.generateWeekByIndex(index)
                }

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

                        CalendarCard(
                            date = date,
                            firstDayOfWeek = firstDayOfWeek,
                            dayOfMonthBackgroundColor = dayOfMonthBackgroundColor,
                            dayOfMonthCurrentTextColor = dayOfMonthCurrentTextColor,
                            dayOfMonthOtherTextColor = dayOfMonthOtherTextColor,
                            dayOfMonthFontFamily = dayOfMonthFontFamily,
                            dayOfMonthFontSize = dayOfMonthFontSize,
                            dayOfWeekColor = dayOfWeekColor,
                            dayOfWeekFontFamily = dayOfWeekFontFamily,
                            dayOfWeekFontSize = dayOfWeekFontSize,
                            dayOfMonthBackgroundShape = dayOfMonthBackgroundShape,
                            currentDayBackgroundColor = currentDayBackgroundColor,
                            selectedDayBackgroundColor = selectedDayBackgroundColor,
                            horizontalDaysPadding = horizontalDaysPadding,
                            verticalDaysPadding = verticalDaysPadding,
                            calendarState = calendarState,
                            onDaySelected = onDaySelected
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