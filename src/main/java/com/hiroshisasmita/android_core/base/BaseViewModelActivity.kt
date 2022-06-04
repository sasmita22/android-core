package com.hiroshisasmita.android_core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelActivity<VM: ViewModel, BIND: ViewDataBinding>: BaseActivity<BIND>() {
    abstract val viewModel: VM
    protected abstract fun setupObservers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
    }
}