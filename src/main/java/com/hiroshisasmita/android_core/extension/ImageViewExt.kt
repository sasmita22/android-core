package com.hiroshisasmita.android_core.extension

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.extLoadImage(uri: Uri, options: RequestOptions) {
    Glide.with(this)
        .load(uri)
        .apply(options)
        .into(this)
}

fun ImageView.extLoadDrawable(@DrawableRes drawable: Int){
    Glide.with(this)
        .load(drawable)
        .into(this)
}