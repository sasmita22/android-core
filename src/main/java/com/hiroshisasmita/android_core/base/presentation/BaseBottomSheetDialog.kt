package com.hiroshisasmita.android_core.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.hiroshisasmita.android_core.R

abstract class BaseBottomSheetDialog<VB: ViewBinding>(
    @StyleRes private val mTheme: Int = R.style.BottomSheetPlainTheme
): BottomSheetDialogFragment() {

    protected lateinit var binding: VB
    abstract val inflateLayout: (LayoutInflater) -> VB
    protected abstract fun setupViews()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateLayout(inflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, mTheme)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }
}