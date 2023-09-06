package com.nekkily.nelendar.util

import java.util.*

/**
 * Wrapped getting a default locale.
 */
class AppLocale: LocaleDefault {
    
    override operator fun invoke(): Locale = Locale.getDefault()
}

interface LocaleDefault {
    operator fun invoke(): Locale
}