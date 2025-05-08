package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiMutation
import com.example.mytemplate.base.contract.UiState

class InitContract {
    sealed interface Event : UiEvent {
        data object Initialize : Event
    }

    data class State(
        val isInitialized: Boolean = false,
        val error: String? = null
    ) : UiState

    sealed interface Effect : UiEffect {
        data object NavigateToMain : Effect
        data class ShowError(val message: String) : Effect
    }

    sealed interface Mutation : UiMutation {
        data object InitComplete : Mutation
    }
}