package com.nekkily.nelendar.util

import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.ui.FirstDayOfWeek
import java.text.DateFormatSymbols
import java.util.*

object CalendarUtil {


    /**
     * Gets the abbreviated names of days of the week.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][String]
     */
    fun getWeekDaysNames(firstDayOfWeek: FirstDayOfWeek): List<String> {
        val names = ArrayList<String>()
        val daysNames = DateFormatSymbols(AppLocale().invoke()).shortWeekdays.toMutableList()
        daysNames.removeAt(0)
        if (firstDayOfWeek == FirstDayOfWeek.MONDAY) {
            val sunday = daysNames.removeAt(0)
            daysNames.add(sunday)
        }
        names.addAll(daysNames)
        return names
    }

    /**
     * Gets the name of the month.
     * @param date [Date] date to bring.
     * @return [String]
     */
    fun getDayOfMonth(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.DAY_OF_MONTH).toString()
    }

    /**
     * Brings the date to the beginning of the day
     * @param date [Date] date to bring.
     * @return [Date] with 00:00:00:00 time.
     */
    fun toDateMidnight(date: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0
        return cal.time
    }

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