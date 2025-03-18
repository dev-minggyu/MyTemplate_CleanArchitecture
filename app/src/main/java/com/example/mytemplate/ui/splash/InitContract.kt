package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiIntent
import com.example.mytemplate.base.contract.UiState

class InitContract {
    sealed class InitIntent : UiIntent {
        data object Initialize : InitIntent()
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