package com.hiroshisasmita.android_core.util.date

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