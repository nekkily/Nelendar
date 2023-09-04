package com.nekkily.nelendar.model.params

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import com.nekkily.nelendar.model.DayModel

class DayParams(
    val dayOfMonthBackgroundColor: Color,
    val dayOfMonthCurrentTextColor: Color,
    val dayOfMonthOtherTextColor: Color,
    val dayOfMonthFontFamily: FontFamily,
    val dayOfMonthFontSize: TextUnit,
    val dayOfWeekColor: Color,
    val dayOfWeekFontFamily: FontFamily,
    val dayOfWeekFontSize: TextUnit,
    val dayOfMonthBackgroundShape: RoundedCornerShape,
    val currentDayBackgroundColor: Color,
    val selectedDayBackgroundColor: Color,
    val onDaySelected: (DayModel) -> Unit,
)