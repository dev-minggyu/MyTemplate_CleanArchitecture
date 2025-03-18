package com.example.mytemplate.ui.main

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiIntent
import com.example.mytemplate.base.contract.UiState

class MainContract {
    sealed class MainIntent : UiIntent {
        data object LoadData : MainIntent()
        data class ClickItem(val id: String) : MainIntent()
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