package com.nekkily.nelendar.util

import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.ui.FirstDayOfWeek
import java.util.*

object CalendarUtil {





    /**
     * @param month [Date] date of the month indicator.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][DayModel] list of days of the month.
     */
    fun getDaysInMonth(month: Date, firstDayOfWeek: FirstDayOfWeek): List<DayModel> {
        val calendar = Calendar.getInstance().clone() as Calendar
        calendar.time = month

        val cells = ArrayList<DayModel>()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val dayOfWeek = getDayOfWeekNumber(calendar, firstDayOfWeek)

        val prevMontDays = dayOfWeek - 1
        val nextMontDays = 35 - prevMontDays - daysInMonth - 1

        for (i in -prevMontDays..daysInMonth + nextMontDays) {
            val dayCalendar = calendar.clone() as Calendar
            dayCalendar.add(Calendar.DAY_OF_MONTH, i)
            cells.add(DayModel(dayCalendar.time, i in 0 until daysInMonth))
        }

        return cells
    }

    /**
     * @param date [Date] date of the week indicator.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][DayModel] list of days of the week.
     */
    fun getDaysInWeek(date: Date, firstDayOfWeek: FirstDayOfWeek):List<DayModel> {
        val calendar = Calendar.getInstance().clone() as Calendar
        calendar.time = date

        val dayOfWeek = getDayOfWeekNumber(calendar, firstDayOfWeek)

        calendar.add(Calendar.DAY_OF_MONTH, -dayOfWeek)

        val cells = ArrayList<DayModel>()
        for (i in 1..DAYS_IN_WEEK) {
            val dayCalendar = calendar.clone() as Calendar
            dayCalendar.add(Calendar.DAY_OF_WEEK, i)
            cells.add(
                DayModel(
                    dayCalendar.time,
                    dayCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
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
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK).let {
            if (it == 1) {
                DAYS_IN_WEEK
            } else {
                it - 1
            }
        }
        return when (firstDayOfWeek) {
            FirstDayOfWeek.MONDAY -> dayOfWeek
            FirstDayOfWeek.SUNDAY -> dayOfWeek + 1
        }
    }
}