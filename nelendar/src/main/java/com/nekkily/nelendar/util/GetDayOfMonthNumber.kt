package com.nekkily.nelendar.util

import java.util.Calendar
import java.util.Date

class GetDayOfMonthNumber {

    /**
     * Gets day of the month number.
     * @param date [Date] date to bring.
     * @return [String]
     */
    operator fun invoke(date: Date): String {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.DAY_OF_MONTH).toString()
    }

}