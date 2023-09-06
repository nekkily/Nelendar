package com.nekkily.nelendar.util

import java.text.SimpleDateFormat
import java.util.Date

class GetMonthNameWithYear(private val locale: LocaleDefault) {

    private val format = "LLLL yyyy"

    /**
     * Gets the month name with year. Takes into account the default system locale.
     * @param month [Date]
     * @return [String]
     */
    operator fun invoke(month: Date): String {
        val locale = locale.invoke()
        return SimpleDateFormat(format, locale).format(month)
            .replaceFirstChar {
                if (it.isLowerCase()) {
                    it.titlecase(locale)
                } else {
                    it.toString()
                }
            }
    }

}