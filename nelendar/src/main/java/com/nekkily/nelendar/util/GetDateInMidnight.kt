package com.nekkily.nelendar.util

import java.util.Calendar
import java.util.Date

class GetDateInMidnight {

    /**
     * Brings the date to the beginning of the day
     * @param date [Date] date to bring.
     * @return [Date] with 00:00:00:000 time.
     */
    operator fun invoke(date: Date): Date {
        val cal = Calendar.getInstance()
        cal.time = date
        cal[Calendar.HOUR_OF_DAY] = 0
        cal[Calendar.MINUTE] = 0
        cal[Calendar.SECOND] = 0
        cal[Calendar.MILLISECOND] = 0
        return cal.time
    }

}