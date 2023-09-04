package com.nekkily.nelendar.util

import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.DAYS_IN_WEEK
import com.nekkily.nelendar.ui.FirstDayOfWeek
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

object CalendarUtil {

    fun generateMonthByIndex(pageIndex: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        val days = arrayListOf(calendar.time)
        days.add(calendar.time)
        calendar.add(Calendar.MONTH, pageIndex)
        return calendar.time
    }

    fun generateWeekByIndex(pageIndex: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = Date()
        val days = arrayListOf(calendar.time)
        days.add(calendar.time)
        calendar.add(Calendar.WEEK_OF_MONTH, pageIndex)
        return calendar.time
    }

    fun getMonthName(month: Date): String {
        return SimpleDateFormat("LLLL yyyy", LocaleDefault()).format(month)
            .replaceFirstChar {
                if (it.isLowerCase()) {
                    it.titlecase(LocaleDefault())
                } else {
                    it.toString()
                }
            }
    }

    fun getWeekDaysNames(firstDayOfWeek: FirstDayOfWeek): ArrayList<String> {
        val names = ArrayList<String>()
        val daysNames = DateFormatSymbols(LocaleDefault()).shortWeekdays.toMutableList()
        daysNames.removeAt(0)
        if (firstDayOfWeek == FirstDayOfWeek.MONDAY) {
            val sunday = daysNames.removeAt(0)
            daysNames.add(sunday)
        }
        names.addAll(daysNames)
        return names
    }

    fun getDayOfMonth(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.DAY_OF_MONTH).toString()
    }

    fun toDateMidnight(date: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0
        return cal.time
    }

    fun getDaysInMonth(month: Date): ArrayList<DayModel> {
        val calendar = Calendar.getInstance().clone() as Calendar
        calendar.time = month

        val cells = ArrayList<DayModel>()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        val dayOfWeek = getDayOfWeek(calendar)

        val prevMontDays = dayOfWeek - 1
        val nextMontDays = 35 - prevMontDays - daysInMonth - 1

        for (i in -prevMontDays..daysInMonth + nextMontDays) {
            val dayCalendar = calendar.clone() as Calendar
            dayCalendar.add(Calendar.DAY_OF_MONTH, i)
            cells.add(DayModel(dayCalendar.time, i in 0 until daysInMonth))
        }

        return cells
    }

    fun getDaysInWeek(date: Date): ArrayList<DayModel> {
        val calendar = Calendar.getInstance().clone() as Calendar
        calendar.time = date

        val dayOfWeek = getDayOfWeek(calendar)

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

    private fun getDayOfWeek(calendar: Calendar): Int {
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        return if (dayOfWeek == 1) {
            DAYS_IN_WEEK
        } else {
            dayOfWeek - 1
        }
    }
}