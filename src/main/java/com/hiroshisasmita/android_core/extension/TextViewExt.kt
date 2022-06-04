package com.hiroshisasmita.android_core.extension

import android.widget.TextView
import androidx.core.text.HtmlCompat

fun TextView.extSetStringHtmlText(text: String) {
    this.text = HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_LEGACY)
}