package com.hiroshisasmita.android_core.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<BIND: ViewDataBinding>: Fragment() {
    protected lateinit var binding: BIND
    protected abstract fun inflateLayout(inflater: LayoutInflater, container: ViewGroup?): BIND
    abstract fun setupViews()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateLayout(inflater, container)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViews()
    }
}