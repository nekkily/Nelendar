package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.model.params.CalendarParams
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.theme.NelendarTheme
import com.nekkily.nelendar.util.AppLocale
import com.nekkily.nelendar.util.GetCalendarSlideIndicatorDate
import com.nekkily.nelendar.util.GetMonthNameWithYear
import java.util.Calendar

/**
 * Main composable view of calendar.
 * Contains [EndlessViewPager] custom composable view that display [CalendarCard] - months or weeks.
 * The name of the month is also displayed.
 *
 * @param params [CalendarParams] calendar params.
 */
@Composable
fun Calendar(
    params: CalendarParams,
    getCalendarSlideIndicatorDate: GetCalendarSlideIndicatorDate = GetCalendarSlideIndicatorDate(Calendar.getInstance()),
    getMonthNameWithYear: GetMonthNameWithYear = GetMonthNameWithYear(AppLocale())
) {
    NelendarTheme {

        EndlessViewPager(
            contentView = { initialPage, pageIndex ->
                val index = pageIndex.minus(initialPage)
                val date = if (params.calendarState == CalendarState.MONTH) {
                    getCalendarSlideIndicatorDate.getInMonth(index)
                } else {
                    getCalendarSlideIndicatorDate.getInWeek(index)
                }

                Box {
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(params.calendarHorizontalPadding, 0.dp),
                            fontSize = params.monthTitleFontSize,
                            fontFamily = params.monthTitleFontFamily,
                            text = getMonthNameWithYear(date),
                            color = params.monthTitleTextColor
                        )

                        Spacer(modifier = Modifier.height(params.calendarMonthTitleBottomPadding))

                        CalendarCard(
                            date = date,
                            params = params
                        )
                    }
                }
            },
            onPageChange = { index ->
                params.onMonthChange(getCalendarSlideIndicatorDate.getInMonth(index))
            }
        )
    }
}