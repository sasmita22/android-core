package com.hiroshisasmita.android_core.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelActivity<VM: ViewModel, BIND: ViewDataBinding>: BaseActivity<BIND>() {
    protected abstract var viewModelClass: Class<VM>
    protected lateinit var viewModel: VM
    protected abstract fun setupObservers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(viewModelClass)
        setupObservers()
    }
}