package com.nekkily.nelendar.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nekkily.nelendar.model.params.CalendarParams
import com.nekkily.nelendar.ui.CalendarState
import com.nekkily.nelendar.ui.theme.NelendarTheme
import com.nekkily.nelendar.util.CalendarUtil
import java.util.*

@Composable
fun Calendar(
    params: CalendarParams
) {
    NelendarTheme {

        EndlessViewPager(
            contentView = { initialPage, pageIndex ->
                val index = pageIndex.minus(initialPage)
                val date = if (params.calendarState == CalendarState.MONTH) {
                    CalendarUtil.generateMonthByIndex(index)
                } else {
                    CalendarUtil.generateWeekByIndex(index)
                }

                Box {
                    Column {
                        Text(
                            modifier = Modifier
                                .padding(params.calendarHorizontalPadding, 0.dp),
                            fontSize = params.monthFontSize,
                            fontFamily = params.monthFontFamily,
                            text = CalendarUtil.getMonthName(date),
                            color = params.monthTextColor
                        )

                        Spacer(modifier = Modifier.height(params.calendarChildrenVerticalPadding))

                        CalendarCard(
                            date = date,
                            params = params
                        )
                    }
                }
            },
            onPageChange = {
                params.onMonthChange(CalendarUtil.generateMonthByIndex(it))
            }
        )
    }
}