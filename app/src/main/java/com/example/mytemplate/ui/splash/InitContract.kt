package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.contract.Effect
import com.example.mytemplate.base.contract.Intent
import com.example.mytemplate.base.contract.State

class InitContract {

    sealed class Intent : com.example.mytemplate.base.contract.Intent {
        object Initialize : Intent()
    }

    data class State(
        val isInitialized: Boolean = false,
        val error: String? = null
    ) : com.example.mytemplate.base.contract.State

    sealed class Effect : com.example.mytemplate.base.contract.Effect {
        object NavigateToMain : Effect()
        data class ShowError(val message: String) : Effect()
    }
}