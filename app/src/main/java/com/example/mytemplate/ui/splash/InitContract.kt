package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiState

class InitContract {
    sealed class InitEvent : UiEvent {
        data object Initialize : InitEvent()
    }

    data class InitState(
        val isInitialized: Boolean = false,
        val error: String? = null
    ) : UiState

    sealed class InitEffect : UiEffect {
        data object NavigateToMain : InitEffect()
        data class ShowError(val message: String) : InitEffect()
    }
}