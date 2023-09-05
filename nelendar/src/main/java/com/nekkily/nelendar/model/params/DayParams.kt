package com.nekkily.nelendar.model.params

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.theme.Gray
import com.nekkily.nelendar.ui.theme.Lavender
import com.nekkily.nelendar.ui.theme.LavenderGray
import com.nekkily.nelendar.ui.theme.LightGray
import com.nekkily.nelendar.ui.theme.White

/**
 * Сalendar day settings model class.
 *
 * @param dayBackgroundColor [Color] to apply to the day cell. Default value [Gray].
 * @param dayCurrentMonthTextColor [Color] to apply to the current month day text. Default value [White].
 * @param dayOtherMonthTextColor [Color] to apply to the other month day text. Default value [Lavender].
 * @param dayFontFamily [FontFamily] font family of day text. Default value [FontFamily.Serif].
 * @param dayFontSize [TextUnit] font size of day text. Default value 20sp[TextUnit].
 * @param dayBackgroundShape [RoundedCornerShape] shape on day cell. Default value 7dp[RoundedCornerShape].
 * @param dayOfWeekColor [Color] to apply to the name of day in week. Default value [Gray].
 * @param dayOfWeekFontFamily  [FontFamily] font family of name of day in week. Default value [FontFamily.Serif].
 * @param dayOfWeekFontSize [TextUnit] font size of name of day in week. Default value 15sp[TextUnit].
 * @param currentDayBackgroundColor [Color] to apply to the today cell. Default value [LightGray].
 * @param selectedDayBackgroundColor [Color] to apply to the selected day cell. Default value [LavenderGray].
 * @param onDaySelected [DayParams] callback informs about the day selection.
 * Returns the [DayModel] of the selected day.
 */
class DayParams(
    val dayBackgroundColor: Color = Gray,
    val dayCurrentMonthTextColor: Color = White,
    val dayOtherMonthTextColor: Color = Lavender,
    val dayFontFamily: FontFamily = FontFamily.Serif,
    val dayFontSize: TextUnit = 20.sp,
    val dayBackgroundShape: RoundedCornerShape = RoundedCornerShape(7.dp),
    val dayOfWeekColor: Color = Gray,
    val dayOfWeekFontFamily: FontFamily = FontFamily.Serif,
    val dayOfWeekFontSize: TextUnit = 15.sp,
    val currentDayBackgroundColor: Color = LightGray,
    val selectedDayBackgroundColor: Color = LavenderGray,
    val onDaySelected: (DayModel) -> Unit = {},
)
