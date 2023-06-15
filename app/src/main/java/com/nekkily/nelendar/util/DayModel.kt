package com.nekkily.nelendar.util

import java.util.Date

data class DayModel(
    val date: Date,
    val isCurrentMonth: Boolean
)