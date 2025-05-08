package com.example.mytemplate.ui.splash

import androidx.lifecycle.viewModelScope
import com.example.mytemplate.base.BaseViewModel
import com.example.mytemplate.utils.extension.reduceToState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onSubscription
import javax.inject.Inject

@HiltViewModel
class InitViewModel @Inject constructor(
    processor: InitProcessor,
    reducer: InitReducer
) : BaseViewModel<InitContract.Event, InitContract.Mutation, InitContract.State, InitContract.Effect>(
    processor = processor,
    reducer = reducer
) {
    override val uiState: StateFlow<InitContract.State> = uiEvent
        .onSubscription { sendEvent(InitContract.Event.Initialize) }
        .reduceToState(
            processor = ::processEvent,
            reducer = ::reduceMutation,
            initialState = InitContract.State(),
            scope = viewModelScope
        )
}