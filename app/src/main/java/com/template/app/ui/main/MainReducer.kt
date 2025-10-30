package com.template.app.ui.main

import com.template.app.base.BaseReducer

class MainReducer : BaseReducer<MainContract.Mutation, MainContract.State, MainContract.Event>() {
    override fun reduce(
        currentState: MainContract.State, mutation: MainContract.Mutation
    ): ReduceResult<MainContract.State, MainContract.Event> {
        return when (mutation) {
            is MainContract.Mutation.ItemClicked -> stateWithEvents(
                newState = currentState,
                eventList = listOf(MainContract.Event.NavigateToDetail(mutation.id))
            )

            is MainContract.Mutation.ShowContent -> stateWithEvents(
                newState = currentState.copy(isLoading = false, data = mutation.list),
                eventList = listOf(MainContract.Event.ShowToast("데이터 로드 완료"))
            )

            MainContract.Mutation.ShowLoader -> stateWithEvents(
                newState = currentState.copy(isLoading = true)
            )

            is MainContract.Mutation.ShowError -> stateWithEvents(
                newState = currentState,
                eventList = listOf(MainContract.Event.ShowToast(mutation.msg))
            )
        }
    }
}