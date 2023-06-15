package com.nekkily.nelendar.util

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

    fun getMonthName(month: Date): String {
        return SimpleDateFormat("LLLL", LocaleDefault.get()).format(month)
            .replaceFirstChar {
                if (it.isLowerCase()) {
                    it.titlecase(LocaleDefault.get())
                } else {
                    it.toString()
                }
            }
    }

    fun getCalendarDays(month: Date, firstDayOfWeek: FirstDayOfWeek): ArrayList<Any> {
        val list = ArrayList<Any>()
        val daysNames = DateFormatSymbols(LocaleDefault.get()).shortWeekdays.toMutableList()
        daysNames.removeAt(0)
        if (firstDayOfWeek == FirstDayOfWeek.MONDAY) {
            val sunday = daysNames.removeAt(0)
            daysNames.add(sunday)
        }
        list.addAll(daysNames)
        list.addAll(getDaysInMonth(month))
        return list
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

    private fun getDaysInMonth(month: Date): ArrayList<DayModel> {
        val calendar = Calendar.getInstance().clone() as Calendar
        calendar.time = month

        val cells = ArrayList<DayModel>()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        calendar.set(Calendar.DAY_OF_MONTH, 1)

        var dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        if (dayOfWeek == 1) {
            dayOfWeek = 7
        } else {
            dayOfWeek -= 1
        }

        val prevMontDays = dayOfWeek - 1
        val nextMontDays = 35 - prevMontDays - daysInMonth - 1

        for (i in -prevMontDays..daysInMonth + nextMontDays) {
            val dayCalendar = calendar.clone() as Calendar
            dayCalendar.add(Calendar.DAY_OF_MONTH, i)
            cells.add(DayModel(dayCalendar.time, i in 0 until daysInMonth))
        }

        return cells
    }
}