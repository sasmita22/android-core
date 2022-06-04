package com.hiroshisasmita.android_core.extension

import android.content.Context
import android.widget.Toast

fun Context.extToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}