package com.nekkily.nelendar

import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.util.GetWeekDaysShortNames
import com.nekkily.nelendar.util.LocaleDefault
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.Locale

class GetWeekDaysShortNamesTest {

    class TestLocale: LocaleDefault {
        override fun invoke(): Locale {
            return Locale.ENGLISH
        }
    }

    @Test
    fun `invoke() first day of week is Monday`() {
        val expected = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")

        val result = GetWeekDaysShortNames(TestLocale()).invoke(FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `invoke() first day of week is Sunday`() {
        val expected = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")

        val result = GetWeekDaysShortNames(TestLocale()).invoke(FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

}