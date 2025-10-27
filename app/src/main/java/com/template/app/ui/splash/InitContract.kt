package com.template.app.ui.splash

import com.template.app.base.contract.UiEvent
import com.template.app.base.contract.UiAction
import com.template.app.base.contract.UiMutation
import com.template.app.base.contract.UiState

class InitContract {
    sealed interface Action : UiAction {
        data object Initialize : Action
    }

    data class State(
        val isInitialized: Boolean = false,
        val error: String? = null
    ) : UiState

    sealed interface Event : UiEvent {
        data object NavigateToMain : Event
        data class ShowError(val message: String) : Event
    }

    sealed interface Mutation : UiMutation {
        data object InitComplete : Mutation
    }
}