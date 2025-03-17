package com.example.mytemplate.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.contract.Effect
import com.example.mytemplate.base.contract.Intent
import com.example.mytemplate.base.contract.State
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<I : Intent, S : State, E : Effect> : ViewModel() {

    private val _state = MutableStateFlow(createInitialState())
    val state: StateFlow<S> = _state.asStateFlow()

    private val _intent = MutableSharedFlow<I>()

    private val _effect = Channel<E>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            _intent.collect { intent ->
                handleIntent(intent)
            }
        }
    }

    protected abstract fun handleIntent(intent: I)

    protected abstract fun createInitialState(): S

    protected val currentState: S
        get() = state.value

    protected fun setState(reduce: S.() -> S) {
        val newState = currentState.reduce()
        _state.value = newState
    }

    protected fun setEffect(effect: E) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }

    fun processIntent(intent: I) {
        viewModelScope.launch {
            _intent.emit(intent)
        }
    }
} 