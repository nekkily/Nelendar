package com.nekkily.nelendar.util

import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.ui.MAX_CELLS_COUNT_IN_MONTH
import java.util.*

class GetCalendarDays {

    /**
     * @param indicatorDate [Date] date of the month indicator.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][DayModel] list of days of the month.
     */
    fun getInMonth(indicatorDate: Date, firstDayOfWeek: FirstDayOfWeek): List<DayModel> {
        val calendar = Calendar.getInstance()
        calendar.time = indicatorDate

        val daysInMonthCount = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val dayOfWeek = getDayOfWeekNumber(calendar, firstDayOfWeek)

        val prevMonthDays = dayOfWeek - 1
        val nextMontDays = MAX_CELLS_COUNT_IN_MONTH - prevMonthDays - daysInMonthCount - 1

        val cells = ArrayList<DayModel>()
        for (i in -prevMonthDays..daysInMonthCount + nextMontDays) {
            val day = calendar.clone() as Calendar
            day.add(Calendar.DAY_OF_MONTH, i)
            cells.add(
                DayModel(
                    day.time,
                    i in 0 until daysInMonthCount
                )
            )
        }

        return cells
    }

    /**
     * @param indicatorDate [Date] date of the week indicator.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][DayModel] list of days of the week.
     */
    fun getInWeek(indicatorDate: Date, firstDayOfWeek: FirstDayOfWeek): List<DayModel> {
        val calendar = Calendar.getInstance()
        calendar.time = indicatorDate

        val indicatorCalendar = calendar.clone() as Calendar

        calendar.firstDayOfWeek = firstDayOfWeek.calendarValue
        calendar.set(Calendar.DAY_OF_WEEK, calendar.firstDayOfWeek)

        val cells = ArrayList<DayModel>()
        for (i in 0 until DAYS_IN_WEEK) {
            val dayCalendar = calendar.clone() as Calendar
            dayCalendar.add(Calendar.DAY_OF_MONTH, i)
            cells.add(
                DayModel(
                    dayCalendar.time,
                    dayCalendar.get(Calendar.MONTH) == indicatorCalendar.get(Calendar.MONTH)
                )
            )
        }

        return cells
    }

    /**
     * @param calendar [Calendar] with date, the day of which you need to get.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [Int] number of week day. Takes into account the selected first day of the week.
     * If [FirstDayOfWeek.MONDAY] first day of week selected Monday has a number 1, Sunday has a
     * number 7. If [FirstDayOfWeek.SUNDAY] first day of week selected Monday has a number 2, Sunday
     * has a number 1.
     */
    private fun getDayOfWeekNumber(calendar: Calendar, firstDayOfWeek: FirstDayOfWeek): Int {
        return when (firstDayOfWeek) {
            FirstDayOfWeek.MONDAY -> {
                calendar.get(Calendar.DAY_OF_WEEK).let {
                    if (it == 1) {
                        DAYS_IN_WEEK
                    } else {
                        it - 1
                    }
                }
            }
            FirstDayOfWeek.SUNDAY -> {
                calendar.get(Calendar.DAY_OF_WEEK)
            }
        }
    }
}