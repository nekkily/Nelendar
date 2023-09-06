package com.nekkily.nelendar

import com.nekkily.nelendar.util.GetDayOfMonthNumber
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat

class GetDayOfMonthNumberTest {

    @Test
    fun `invoke() one date`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val result = GetDayOfMonthNumber().invoke(date)

        assertEquals("6", result)
    }

    @Test
    fun `invoke() two date`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2023-12-18")!!

        val result = GetDayOfMonthNumber().invoke(date)

        assertEquals("18", result)
    }

    @Test
    fun `invoke() test that incoming parameter does not change`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2027-12-30")!!

        val expected = date.clone()

        GetDayOfMonthNumber().invoke(date)

        assertEquals(expected, date)
    }
}