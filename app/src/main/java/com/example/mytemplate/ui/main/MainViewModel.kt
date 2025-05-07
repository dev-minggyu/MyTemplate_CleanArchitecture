package com.example.mytemplate.ui.main

import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.ui.main.MainContract.MainEffect
import com.example.mytemplate.ui.main.MainContract.MainEvent
import com.example.mytemplate.ui.main.MainContract.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel<MainEvent, MainState, MainEffect>() {

    override fun createInitialState(): MainState = MainState()

    override fun handleEvent(event: MainEvent) {
        when (event) {
            is MainEvent.LoadData -> loadData()
            is MainEvent.ClickItem -> handleItemClick(event.id)
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

        setEffect(MainEffect.ShowToast("데이터 로드 완료"))
    }

    private fun handleItemClick(id: String) {
        setEffect(MainEffect.NavigateToDetail(id))
    }
}