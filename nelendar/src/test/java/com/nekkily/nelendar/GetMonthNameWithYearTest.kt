package com.nekkily.nelendar

import com.nekkily.nelendar.util.GetMonthNameWithYear
import com.nekkily.nelendar.util.LocaleDefault
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Locale

class GetMonthNameWithYearTest {

    class TestLocale: LocaleDefault {
        override fun invoke(): Locale {
            return Locale.ENGLISH
        }
    }

    @Test
    fun `invoke() one date`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val result = GetMonthNameWithYear(TestLocale()).invoke(date)

        assertEquals("September 2023", result)
    }

    @Test
    fun `invoke() two date`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2027-12-30")!!

        val result = GetMonthNameWithYear(TestLocale()).invoke(date)

        assertEquals("December 2027", result)
    }
}