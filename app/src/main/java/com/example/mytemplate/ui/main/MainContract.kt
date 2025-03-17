package com.example.mytemplate.ui.main

import com.example.mytemplate.base.contract.Effect
import com.example.mytemplate.base.contract.Intent
import com.example.mytemplate.base.contract.State

class MainContract {

    sealed class Intent : com.example.mytemplate.base.contract.Intent {
        object LoadData : Intent()
        data class ClickItem(val id: String) : Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val data: List<String> = emptyList(),
        val error: String? = null
    ) : com.example.mytemplate.base.contract.State

    sealed class Effect : com.example.mytemplate.base.contract.Effect {
        data class ShowToast(val message: String) : Effect()
        data class NavigateToDetail(val id: String) : Effect()
    }
}