package com.example.mytemplate.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.ui.splash.InitContract.InitEffect
import com.example.mytemplate.ui.splash.InitContract.InitEvent
import com.example.mytemplate.ui.splash.InitContract.InitState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor() : BaseViewModel<InitEvent, InitState, InitEffect>() {

    override fun createInitialState(): InitState = InitState()

    override fun handleEvent(event: InitEvent) {
        when (event) {
            is InitEvent.Initialize -> initialize()
        }
    }

    private fun initialize() {
        viewModelScope.launch {
            try {
                delay(1000)

                setState { copy(isInitialized = true) }

                setEffect(InitEffect.NavigateToMain)
            } catch (e: Exception) {
                setState { copy(error = e.message) }

                setEffect(InitEffect.ShowError(e.message ?: "초기화 중 오류가 발생했습니다."))
            }
        }
    }
}