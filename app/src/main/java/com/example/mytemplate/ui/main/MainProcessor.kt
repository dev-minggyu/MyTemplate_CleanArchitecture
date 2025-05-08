package com.example.mytemplate.ui.main

import com.example.mytemplate.base.BaseProcessor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class MainProcessor @Inject constructor() : BaseProcessor<MainContract.Event, MainContract.Mutation>() {
    override fun process(event: MainContract.Event): Flow<MainContract.Mutation> {
        return when (event) {
            MainContract.Event.LoadData -> flow {
                emit(MainContract.Mutation.ShowLoader)
                delay(500) // mock network
                runCatching {
                    listOf("Item 1", "Item 2", "Item 3")
                }.onSuccess {
                    emit(MainContract.Mutation.ShowContent(it))
                }.onFailure {
                    emit(MainContract.Mutation.ShowError("로드 실패"))
                }
            }

            is MainContract.Event.ClickItem -> {
                flowOf(MainContract.Mutation.ItemClicked(event.id))
            }
        }
    }
}