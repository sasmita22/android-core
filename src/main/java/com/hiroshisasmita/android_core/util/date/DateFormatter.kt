package com.hiroshisasmita.android_core.util.date

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    fun formatDate(
        date: Date,
        format: DateFormat,
        locale: Locale = Locale.getDefault(),
        timeZone: TimeZone = TimeZone.getDefault()
    ): String {
        return SimpleDateFormat(format.format, locale).run {
            this.timeZone = timeZone
            format(date)
        }
    }

    fun changeDateStringFormat(
        dateString: String,
        formatBefore: DateFormat,
        formatAfter: DateFormat,
        localeBefore: Locale = Locale.getDefault(),
        localeAfter: Locale = Locale.getDefault(),
        timeZoneBefore: TimeZone = TimeZone.getDefault(),
        timeZoneAfter: TimeZone = TimeZone.getDefault()
    ): String? {
        return try {
            SimpleDateFormat(formatBefore.format, localeBefore).run {
                this.timeZone = timeZoneBefore
                parse(dateString)
            }?.let { date ->
                val formatter = SimpleDateFormat(formatAfter.format, localeAfter)
                formatter.timeZone = timeZoneAfter
                formatter.format(date)
            }
        } catch (e: Exception) {
            return null
        }
    }
}