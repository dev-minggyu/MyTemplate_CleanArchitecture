package com.example.mytemplate.ui.main

import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.ui.main.MainContract.Effect
import com.example.mytemplate.ui.main.MainContract.Intent
import com.example.mytemplate.ui.main.MainContract.State
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<Intent, State, Effect>() {

    override fun createInitialState(): State = State()

    override fun handleIntent(intent: Intent) {
        when (intent) {
            is Intent.LoadData -> loadData()
            is Intent.ClickItem -> handleItemClick(intent.id)
        }
    }

    private fun loadData() {
        setState { copy(isLoading = true) }

        val mockData = listOf("Item 1", "Item 2", "Item 3")
        
        setState { 
            copy(
                isLoading = false,
                data = mockData
            )
        }

        setEffect(Effect.ShowToast("데이터 로드 완료"))
    }

    private fun handleItemClick(id: String) {
        setEffect(Effect.NavigateToDetail(id))
    }
}