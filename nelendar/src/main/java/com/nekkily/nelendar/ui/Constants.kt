package com.nekkily.nelendar.ui

import java.util.Calendar


/**
 * Contains the max cells count in month that displayed on screen.
 */
const val MAX_CELLS_COUNT_IN_MONTH = 35

/**
 * Contains the number of days in a week.
 */
const val DAYS_IN_WEEK = 7

/**
 * Represents the day from which the week will start.
 * @see FirstDayOfWeek.MONDAY
 * @see FirstDayOfWeek.SUNDAY
 */
enum class FirstDayOfWeek(val calendarValue: Int) {
    /**
     * Indicates that the week will start on Monday.
     */
    MONDAY(Calendar.MONDAY),
    /**
     * Indicates that the week will start on Sunday.
     */
    SUNDAY(Calendar.SUNDAY)
}

/**
 * Represents in what form the calendar will be displayed.
 * @see CalendarState.MONTH
 * @see CalendarState.WEEK
 */
enum class CalendarState {
    /**
     * Indicates that the calendar will be displayed by month.
     */
    MONTH,
    /**
     * Indicates that the calendar will be displayed by week.
     */
    WEEK
}