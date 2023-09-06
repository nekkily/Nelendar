package com.nekkily.nelendar

import com.nekkily.nelendar.util.GetDateInMidnight
import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat

class GetDateInMidnightTest {

    @Test
    fun `invoke() current time is midnight`() {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 00:00:00:000")!!

        val result = GetDateInMidnight().invoke(date)

        Assert.assertEquals(date, result)
    }

    @Test
    fun `invoke() current time is middle of day`() {
        val midnightDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 00:00:00:000")!!
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 15:04:30:010")!!

        val result = GetDateInMidnight().invoke(date)

        Assert.assertEquals(midnightDate, result)
    }

    @Test
    fun `invoke() current time is end of day`() {
        val midnightDate = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 00:00:00:000")!!
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 23:59:59:999")!!

        val result = GetDateInMidnight().invoke(date)

        Assert.assertEquals(midnightDate, result)
    }

    @Test
    fun `invoke() test that incoming parameter does not change`() {
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").parse("2023-09-06 23:59:59:999")!!
        val expected = date.clone()

        GetDateInMidnight().invoke(date)

        Assert.assertEquals(expected, date)
    }

}