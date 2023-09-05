package com.nekkily.nelendar.model

import java.util.Date

/**
 * Day model class.
 *
 * @param date [Date] contains full date of the day.
 * @param isCurrentMonth [Boolean] indicates if this day belongs to month that prevails on the screen.
 */
data class DayModel(
    val date: Date,
    val isCurrentMonth: Boolean
)