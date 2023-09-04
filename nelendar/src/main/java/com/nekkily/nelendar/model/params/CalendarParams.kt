package com.nekkily.nelendar.model.params

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.FirstDayOfWeek
import java.util.Date

class CalendarParams(
    val firstDayOfWeek: FirstDayOfWeek,
    val monthTextColor: Color,
    val monthFontFamily: FontFamily,
    val monthFontSize: TextUnit,
    val calendarHorizontalPadding: Dp,
    val calendarChildrenVerticalPadding: Dp,
    val horizontalDaysPadding: Dp,
    val verticalDaysPadding: Dp,
    val calendarState: CalendarState,
    val selectedDay: MutableState<DayModel>,
    val onMonthChange: (Date) -> Unit,
    val dayParams: DayParams
)