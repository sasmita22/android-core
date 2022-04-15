package com.hiroshisasmita.android_core.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelFragment<VM: ViewModel, BIND: ViewDataBinding>: BaseFragment<BIND>() {
    protected lateinit var viewModel: VM
    abstract val viewModelClass: Class<VM>
    abstract fun setupObservers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(viewModelClass)
        setupObservers()
    }
}