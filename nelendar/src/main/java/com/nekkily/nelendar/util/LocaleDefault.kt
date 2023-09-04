package com.nekkily.nelendar.util

import java.util.*

object LocaleDefault {
    
    operator fun invoke(): Locale = Locale.getDefault()
}