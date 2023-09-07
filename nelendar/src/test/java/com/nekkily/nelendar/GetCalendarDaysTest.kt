package com.nekkily.nelendar

import com.nekkily.nelendar.model.DayModel
import com.nekkily.nelendar.ui.FirstDayOfWeek
import com.nekkily.nelendar.util.GetCalendarDays
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Calendar

class GetCalendarDaysTest {

    @Test
    fun `getInMonth() first day of week is Monday, slide contains prev month days and next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -4..-1, false)
        fillArray(localCalendar, expected, 0..29, true)
        fillArray(localCalendar, expected, 30 until 31, false)

        val result = GetCalendarDays().getInMonth(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() first day of week is Monday, slide contains prev month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-12-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -4..-1, false)
        fillArray(localCalendar, expected, 0..30, true)

        val result = GetCalendarDays().getInMonth(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() first day of week is Monday, slide contains next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2024-01-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, 0..30, true)
        fillArray(localCalendar, expected, 31..34, false)

        val result = GetCalendarDays().getInMonth(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() first day of week is Sunday, slide contains prev month days and next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-11-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -3..-1, false)
        fillArray(localCalendar, expected, 0 .. 29, true)
        fillArray(localCalendar, expected, 30 until 32, false)

        val result = GetCalendarDays().getInMonth(calendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() first day of week is Sunday, slide contains prev month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -5..-1, false)
        fillArray(localCalendar, expected, 0..29, true)

        val result = GetCalendarDays().getInMonth(localCalendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() first day of week is Sunday, slide contains next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-10-06")!!

        val localCalendar = calendar.clone() as Calendar
        localCalendar.add(Calendar.DAY_OF_MONTH, -5)

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, 0..30, true)
        fillArray(localCalendar, expected, 31 until 35, false)

        val result = GetCalendarDays().getInMonth(calendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Monday, slide contains prev month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-01")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -4..-1, true)
        fillArray(localCalendar, expected, 0 .. 2, false)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Monday, slide contains only current month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -2 .. 4, true)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Monday, slide contains next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-11-29")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -2 .. 1, true)
        fillArray(localCalendar, expected, 2 .. 4, false)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.MONDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Sunday, slide contains prev month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-02")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -3 .. -2, true)
        fillArray(localCalendar, expected, -1 .. 3, false)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Sunday, slide contains only current month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-08-06")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, 0 .. 6, true)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInWeek() first day of week is Sunday, slide contains next month days`() {
        val calendar = Calendar.getInstance()
        calendar.time = SimpleDateFormat("yyyy-MM-dd").parse("2023-10-31")!!

        val localCalendar = calendar.clone() as Calendar

        val expected = ArrayList<DayModel>()
        fillArray(localCalendar, expected, -2 .. 0, true)
        fillArray(localCalendar, expected, 1 .. 4, false)

        val result = GetCalendarDays().getInWeek(calendar.time, FirstDayOfWeek.SUNDAY)

        assertEquals(expected, result)
    }

    @Test
    fun `getInMonth() test that incoming parameter does not change`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!
        val expected = date.clone()

        GetCalendarDays().getInMonth(date, FirstDayOfWeek.MONDAY)

        Assert.assertEquals(expected, date)

        GetCalendarDays().getInMonth(date, FirstDayOfWeek.SUNDAY)

        Assert.assertEquals(expected, date)
    }

    @Test
    fun `getInWeek() test that incoming parameter does not change`() {
        val date = SimpleDateFormat("yyyy-MM-dd").parse("2023-09-06")!!
        val expected = date.clone()

        GetCalendarDays().getInWeek(date, FirstDayOfWeek.SUNDAY)

        Assert.assertEquals(expected, date)

        GetCalendarDays().getInWeek(date, FirstDayOfWeek.SUNDAY)

        Assert.assertEquals(expected, date)
    }

    private fun fillArray(calendar: Calendar, array: ArrayList<DayModel>, range: IntRange, isCurrentMonth: Boolean) {
        for (i in range) {
            val localCalendar = calendar.clone() as Calendar
            localCalendar.add(Calendar.DAY_OF_MONTH, i)
            array.add(
                DayModel(
                    date = localCalendar.time,
                    isCurrentMonth = isCurrentMonth
                )
            )
        }
    }

}