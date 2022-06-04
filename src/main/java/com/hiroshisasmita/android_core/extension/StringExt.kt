package com.hiroshisasmita.android_core.extension

import java.lang.NumberFormatException


fun String.extCapWords(): String = split(" ").joinToString(" ") { itString ->
    itString.lowercase()
        .replaceFirstChar {
            it.uppercase()
        }
}

fun String.extCapSentence() = this.lowercase().replaceFirstChar { it.uppercase() }