package com.example.mytemplate.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<Event : UiEvent, State : UiState, Effect : UiEffect> : ViewModel() {

    private val _state: MutableStateFlow<State> by lazy { MutableStateFlow(createInitialState()) }
    val state: StateFlow<State> = _state.asStateFlow()

    private val _event = MutableSharedFlow<Event>()

    private val _effect = Channel<Effect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    init {
        viewModelScope.launch {
            _event.collect { intent ->
                handleEvent(intent)
            }
        }
    }

    protected abstract fun handleEvent(event: Event)

    protected abstract fun createInitialState(): State

    protected val currentState: State
        get() = state.value

    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        _state.value = newState
    }

    protected fun setEffect(effect: Effect) {
        viewModelScope.launch {
            _effect.send(effect)
        }
    }

    fun processEvent(event: Event) {
        viewModelScope.launch {
            _event.emit(event)
        }
    }
} 