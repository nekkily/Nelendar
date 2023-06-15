package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.nekkily.nelendar.ui.FirstDayOfWeek

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
    calendarHorizontalPadding: Dp,
    calendarChildrenVerticalPadding: Dp,
    horizontalDaysPadding: Dp,
    verticalDaysPadding: Dp
) {

}