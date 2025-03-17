package com.example.mytemplate.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.mytemplate.base.contract.Effect
import com.example.mytemplate.base.contract.Intent
import com.example.mytemplate.base.contract.State
import kotlinx.coroutines.launch

abstract class BaseActivity<T : ViewBinding, I : Intent, S : State, E : Effect, VM : BaseViewModel<I, S, E>> : AppCompatActivity() {
    private var _binding: T? = null
    val binding get() = _binding!!

    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = inflateViewBinding()
        setContentView(binding.root)

        initView()
        observeState()
        observeEffect()
    }

    abstract fun inflateViewBinding(): T

    abstract fun initView()

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    renderState(state)
                }
            }
        }
    }

    private fun observeEffect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect { effect ->
                    handleEffect(effect)
                }
            }
        }
    }

    abstract fun renderState(state: S)

    abstract fun handleEffect(effect: E)

    fun processIntent(intent: I) {
        viewModel.processIntent(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}