package com.nekkily.nelendar.model.params

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.ui.theme.White
import java.util.Date

/**
 * Сalendar settings model class.
 *
 * @param firstDayOfWeek indicates which day the week starts from. Can take the values
 * [FirstDayOfWeek.MONDAY] and [FirstDayOfWeek.SUNDAY]. Default value [FirstDayOfWeek.MONDAY].
 * @param monthTitleTextColor [Color] to apply to the month name title. Default value [White].
 * @param monthTitleFontFamily [FontFamily] font family of month name title. Default value [FontFamily.Serif].
 * @param monthTitleFontSize [TextUnit] font size of month name title. Default value 32sp[TextUnit].
 * @param calendarHorizontalPadding [Dp] horizontal padding from both sides on root view - calendar. Default value 26dp[Dp].
 * @param calendarMonthTitleBottomPadding [Dp] padding between month title and calendar cells. Default value 26dp[Dp].
 * @param horizontalDaysPadding [Dp] horizontal distance between calendar cells. Default value 8dp[Dp].
 * Note that this is the total distance, not from each cell.
 * @param verticalDaysPadding [Dp] vertical distance between calendar cells. Default value 8dp[Dp].
 * Note that this is the total distance, not from each cell.
 * @param calendarState [CalendarState] visual display of the calendar by month or week. Default value [CalendarState.WEEK].
 * @param selectedDay [MutableState][DayModel] remember state of selected day.
 * Contains the [DayModel] of the selected day.
 * @param dayParams [DayParams] params model for detailed day settings.
 */
class CalendarParams(
    val firstDayOfWeek: FirstDayOfWeek = FirstDayOfWeek.MONDAY,
    val monthTitleTextColor: Color = White,
    val monthTitleFontFamily: FontFamily = FontFamily.Serif,
    val monthTitleFontSize: TextUnit = 32.sp,
    val calendarHorizontalPadding: Dp = 26.dp,
    val calendarMonthTitleBottomPadding: Dp = 14.dp,
    val horizontalDaysPadding: Dp = 8.dp,
    val verticalDaysPadding: Dp = 8.dp,
    val calendarState: CalendarState = CalendarState.WEEK,
    val selectedDay: MutableState<DayModel>,
    val onMonthChange: (Date) -> Unit,
    val dayParams: DayParams
)