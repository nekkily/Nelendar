package com.nekkily.nelendar.model

import java.util.Date

data class DayModel(
    val date: Date,
    val isCurrentMonth: Boolean
)