package com.nexters.moss._base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel

abstract class BaseDialog<T: ViewDataBinding> : DialogFragment() {
    abstract val vm: ViewModel

    protected val binding by lazy {
        DataBindingUtil.inflate(inflater, getLayoutRes(), container, false) as T
    }

    private lateinit var inflater: LayoutInflater
    private var container: ViewGroup? = null

    @LayoutRes
    abstract fun getLayoutRes(): Int
    abstract fun setupBinding()
    abstract fun getDialogWidth(): Int
    abstract fun getDialogHeight(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.inflater = inflater
        this.container = container

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupBinding()
        binding.lifecycleOwner = this

        val width = (getDialogWidth() * resources.displayMetrics.density + 0.5f).toInt()
        val height = (getDialogHeight() * resources.displayMetrics.density + 0.5f).toInt()

        dialog?.window?.setLayout(width, height)
    }

    fun toast(content: String) {
        with(activity) {
            if (this == null) {
                return
            }
            Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
        }
    }
}