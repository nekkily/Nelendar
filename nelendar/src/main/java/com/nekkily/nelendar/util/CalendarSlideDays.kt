package com.nekkily.nelendar.util

import java.util.Calendar
import java.util.Date

/**
 * Util to get indicator date of month or week slide. Depends on the current date.
 */
class CalendarSlideDays(private val calendar: Calendar) {

    /**
     * Gets month indicator date by index.
     * @param pageIndex [Int]
     * @return [Date]
     */
    fun getInMonth(pageIndex: Int): Date {
        return generateValueByIndex(Calendar.MONTH, pageIndex)
    }

    /**
     * Gets week indicator date by index.
     * @param pageIndex [Int]
     * @return [Date]
     */
    fun getInWeek(pageIndex: Int): Date {
        return generateValueByIndex(Calendar.WEEK_OF_MONTH, pageIndex)
    }

    private fun generateValueByIndex(value: Int, pageIndex: Int): Date {
        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(value, pageIndex)
        return localCalendar.time
    }

}