package com.example.mytemplate.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiMutation
import com.example.mytemplate.base.contract.UiState
import kotlinx.coroutines.launch

abstract class BaseActivity<T : ViewBinding, Event : UiEvent, Mutation : UiMutation, State : UiState, Effect : UiEffect, VM : BaseViewModel<Event, Mutation, State, Effect>> :
    AppCompatActivity() {
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
                viewModel.uiState.collect { state ->
                    renderState(state)
                }
            }
        }
    }

    private fun observeEffect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEffect.collect { effect ->
                    handleEffect(effect)
                }
            }
        }
    }

    abstract fun renderState(state: State)

    abstract fun handleEffect(effect: Effect)

    fun sendEvent(event: Event) {
        viewModel.sendEvent(event)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}