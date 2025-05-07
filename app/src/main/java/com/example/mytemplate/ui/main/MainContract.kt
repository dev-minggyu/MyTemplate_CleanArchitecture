package com.example.mytemplate.ui.main

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiState

class MainContract {
    sealed class MainEvent : UiEvent {
        data object LoadData : MainEvent()
        data class ClickItem(val id: String) : MainEvent()
    }

    data class MainState(
        val isLoading: Boolean = false,
        val data: List<String> = emptyList(),
        val error: String? = null
    ) : UiState

    sealed class MainEffect : UiEffect {
        data class ShowToast(val message: String) : MainEffect()
        data class NavigateToDetail(val id: String) : MainEffect()
    }
}