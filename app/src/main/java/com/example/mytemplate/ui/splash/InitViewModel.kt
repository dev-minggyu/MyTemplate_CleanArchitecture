package com.example.mytemplate.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.ui.splash.InitContract.Effect
import com.example.mytemplate.ui.splash.InitContract.Intent
import com.example.mytemplate.ui.splash.InitContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor() : BaseViewModel<Intent, State, Effect>() {

    override fun createInitialState(): State = State()

    override fun handleIntent(intent: Intent) {
        when (intent) {
            is Intent.Initialize -> initialize()
        }
    }

    private fun initialize() {
        viewModelScope.launch {
            try {
                delay(1000)

                setState { copy(isInitialized = true) }

                setEffect(Effect.NavigateToMain)
            } catch (e: Exception) {
                setState { copy(error = e.message) }

                setEffect(Effect.ShowError(e.message ?: "초기화 중 오류가 발생했습니다."))
            }
        }
    }
}