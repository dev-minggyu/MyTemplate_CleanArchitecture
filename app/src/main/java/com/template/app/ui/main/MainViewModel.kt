package com.template.app.ui.main

import androidx.lifecycle.viewModelScope
import com.template.app.base.BaseViewModel
import com.template.app.utils.extension.reduceToState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onSubscription

class MainViewModel(
    private val processor: MainProcessor,
    private val reducer: MainReducer
) : BaseViewModel<MainContract.Action, MainContract.Mutation, MainContract.State, MainContract.Event>(
    processor = processor,
    reducer = reducer
) {
    override val uiState: StateFlow<MainContract.State> = uiAction
        .onSubscription { sendAction(MainContract.Action.LoadData) }
        .reduceToState(
            processor = ::processAction,
            reducer = ::reduceMutation,
            initialState = MainContract.State(),
            scope = viewModelScope
        )
}