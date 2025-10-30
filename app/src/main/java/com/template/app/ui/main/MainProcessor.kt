package com.template.app.ui.main

import com.template.app.base.BaseProcessor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

class MainProcessor : BaseProcessor<MainContract.Action, MainContract.Mutation>() {
    override fun process(action: MainContract.Action): Flow<MainContract.Mutation> {
        return when (action) {
            MainContract.Action.LoadData -> flow {
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

            is MainContract.Action.ClickItem -> {
                flowOf(MainContract.Mutation.ItemClicked(action.id))
            }
        }
    }
}