package com.nekkily.nelendar.util

import java.util.*

/**
 * Wrapped getting a default locale.
 */
object LocaleDefault {
    
    operator fun invoke(): Locale = Locale.getDefault()
}