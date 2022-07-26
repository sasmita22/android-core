package com.hiroshisasmita.android_core.base.presentation

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.hiroshisasmita.android_core.exception.BadRequestException

abstract class BaseViewModelActivity<VM: ViewModel, BIND: ViewDataBinding>: BaseActivity<BIND>() {
    abstract val viewModel: VM
    protected abstract fun setupObservers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()
    }
}