package com.nekkily.nelendar.util

import com.nekkily.nelendar.ui.FirstDayOfWeek
import java.text.DateFormatSymbols
import java.util.ArrayList

class GetWeekDaysShortNames(private val locale: LocaleDefault) {

    /**
     * Gets the abbreviated names of days of the week.
     * @param firstDayOfWeek [FirstDayOfWeek] selected first day of the week.
     * @return [List][String]
     */
    operator fun invoke(firstDayOfWeek: FirstDayOfWeek): List<String> {
        val names = ArrayList<String>()
        val daysNames = DateFormatSymbols(locale()).shortWeekdays.toMutableList()
        daysNames.removeAt(0)
        if (firstDayOfWeek == FirstDayOfWeek.MONDAY) {
            val sunday = daysNames.removeAt(0)
            daysNames.add(sunday)
        }
        names.addAll(daysNames)
        return names
    }

}