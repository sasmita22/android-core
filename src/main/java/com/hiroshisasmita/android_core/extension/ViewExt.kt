package com.hiroshisasmita.android_core.extension

import android.view.View

fun View.extVisible() {
    visibility = View.VISIBLE
}

fun View.extInvisible() {
    visibility = View.INVISIBLE
}

fun View.extGone() {
    visibility = View.GONE
}