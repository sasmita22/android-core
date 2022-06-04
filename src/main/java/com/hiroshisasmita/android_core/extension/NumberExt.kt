package com.hiroshisasmita.android_core.extension

import android.content.Context
import java.text.NumberFormat
import java.util.*

fun Int.extIdrCurrencyFormatted(): String {
    return toLong().extIdrCurrencyFormatted()
}

fun Long.extIdrCurrencyFormatted(): String {
    val numberFormat = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
    numberFormat.maximumFractionDigits = 0
    val formatted = numberFormat.format(this)
    val subStr = formatted.substring(2, formatted.length)
    return "Rp " + subStr.replace(",",".")
}

fun Int.extToPX(context: Context): Int = (this * context.resources.displayMetrics.density).toInt()

fun Int.extToDp(context: Context): Int = (this / context.resources.displayMetrics.density).toInt()