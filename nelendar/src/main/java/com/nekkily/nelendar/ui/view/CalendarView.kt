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
import com.nekkily.nelendar.util.CalendarSlideDays
import com.nekkily.nelendar.util.CalendarUtil
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
    calendarSlideDays: CalendarSlideDays = CalendarSlideDays(Calendar.getInstance())
) {
    NelendarTheme {

        EndlessViewPager(
            contentView = { initialPage, pageIndex ->
                val index = pageIndex.minus(initialPage)
                val date = if (params.calendarState == CalendarState.MONTH) {
                    calendarSlideDays.getInMonth(index)
                } else {
                    calendarSlideDays.getInWeek(index)
                }

                Box {
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(params.calendarHorizontalPadding, 0.dp),
                            fontSize = params.monthTitleFontSize,
                            fontFamily = params.monthTitleFontFamily,
                            text = CalendarUtil.getMonthName(date),
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
                params.onMonthChange(calendarSlideDays.getInMonth(index))
            }
        )
    }
}