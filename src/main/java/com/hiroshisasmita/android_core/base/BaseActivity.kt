package com.hiroshisasmita.android_core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<BIND: ViewDataBinding>: AppCompatActivity() {
    protected lateinit var binding: BIND

    protected abstract fun inflateLayout(layoutInflater: LayoutInflater): BIND

    protected abstract fun setupViews()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateLayout(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }
}