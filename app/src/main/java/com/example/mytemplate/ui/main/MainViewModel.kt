package com.example.mytemplate.ui.main

import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.utils.extension.reduceToState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onSubscription
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    processor: MainProcessor,
    reducer: MainReducer
) : BaseViewModel<MainContract.Event, MainContract.Mutation, MainContract.State, MainContract.Effect>(
    processor = processor,
    reducer = reducer
) {
    override val uiState: StateFlow<MainContract.State> = uiEvent
        .onSubscription { sendEvent(MainContract.Event.LoadData) }
        .reduceToState(
            processor = ::processEvent,
            reducer = ::reduceMutation,
            initialState = MainContract.State(),
            scope = viewModelScope
        )
}