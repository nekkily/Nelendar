package com.nekkily.nelendar

import com.nekkily.nelendar.util.GetCalendarSlideIndicatorDate
import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.Calendar

class GetCalendarSlideIndicatorDateTest {

    @Test
    fun `getInMonth() page index is 0`() {
        //It is current month with index 0
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val result = GetCalendarSlideIndicatorDate(calendar).getInMonth(0)

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInMonth() page index less than 0`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!
        val util = GetCalendarSlideIndicatorDate(calendar)

        var result = util.getInMonth(-1)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-06")!!

        assertEquals(calendar.time, result)

        result = util.getInMonth(-30)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2021-02-06")!!

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInMonth() page index more than 0`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-06")!!
        val util = GetCalendarSlideIndicatorDate(calendar)

        var result = util.getInMonth(1)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        assertEquals(calendar.time, result)

        result = util.getInMonth(50)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2027-11-06")!!

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInWeek() page index is 0`() {
        //It is current month with index 0
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val result = GetCalendarSlideIndicatorDate(calendar).getInWeek(0)

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInWeek() page index less than 0`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!
        val util = GetCalendarSlideIndicatorDate(calendar)

        var result = util.getInWeek(-1)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-30")!!

        assertEquals(calendar.time, result)

        result = util.getInWeek(-30)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-02-01")!!

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInWeek() page index more than 0`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!
        val util = GetCalendarSlideIndicatorDate(calendar)

        var result = util.getInWeek(1)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-13")!!

        assertEquals(calendar.time, result)

        result = util.getInWeek(50)

        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2024-08-28")!!

        assertEquals(calendar.time, result)
    }

    @Test
    fun `getInWeek() test that incoming parameter does not change`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val expected = calendar.clone()

        GetCalendarSlideIndicatorDate(calendar).getInWeek(3)

        assertEquals(expected, calendar)
    }

    @Test
    fun `getInMonth() test that incoming parameter does not change`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val expected = calendar.clone()

        GetCalendarSlideIndicatorDate(calendar).getInMonth(3)

        assertEquals(expected, calendar)
    }
}