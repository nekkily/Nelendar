package com.nekkily.nelendar.model

import java.util.Date

data class Day(
    val date: Date,
    val isCurrentMonth: Boolean
)