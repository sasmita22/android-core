package com.hiroshisasmita.android_core.extension

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.extLoadImage(url: String, options: RequestOptions = RequestOptions()) {
    Glide.with(this)
        .load(url)
        .apply(options)
        .into(this)
}

fun ImageView.extLoadDrawable(@DrawableRes drawable: Int){
    Glide.with(this)
        .load(drawable)
        .into(this)
}