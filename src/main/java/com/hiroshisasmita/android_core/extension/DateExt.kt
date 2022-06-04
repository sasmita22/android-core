package com.hiroshisasmita.android_core.extension

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

enum class DateFormat(val format: String) {
    YYYY("yyyy"),
    HH_MM("HH:mm"),
    HH_MM_SS("HH:mm:ss"),
    YYYY_MM_DD_DASH("yyyy-MM-dd"),
    DD_MM_YYYY_DASH("dd-MM-yyyy"),
    EEEE_DD_MMM_YYYY("EEEE, dd MMMM yyyy"),
    DD_MMMM_YYYY("dd MMMM yyyy"),
    UTC_FORMAT("yyyy-MM-dd'T'HH:mm:ss.SSSZ"),
    UTC_FORMAT2("yyyy-MM-dd HH:mm:ss Z"),
    UTC_FORMAT3("yyyy-MM-dd'T'HH:mm:ss'Z'")
}

fun Date.extFetchDateString(format: DateFormat, timeZone: TimeZone = TimeZone.getDefault()): String {
    return SimpleDateFormat(format.format, Locale.getDefault()).run {
        this.timeZone = timeZone
        format(this@extFetchDateString)
    }
}

fun String.extFormatDateString(
    formatBefore: DateFormat,
    formatAfter: DateFormat,
    timeZoneBefore: TimeZone = TimeZone.getDefault(),
    timeZoneAfter: TimeZone = TimeZone.getDefault()
): String? {
    return try {
        SimpleDateFormat(formatBefore.format, Locale.getDefault()).run {
            this.timeZone = timeZoneBefore
            parse(this@extFormatDateString)
        }?.let { date ->
            val formatter = SimpleDateFormat(formatAfter.format, Locale.getDefault())
            formatter.timeZone = timeZoneAfter
            formatter.format(date)
        }
    } catch (e: Exception) {
        return null
    }
}