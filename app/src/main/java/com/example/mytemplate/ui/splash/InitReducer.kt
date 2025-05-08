package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.BaseReducer
import javax.inject.Inject

class InitReducer @Inject constructor() : BaseReducer<InitContract.Mutation, InitContract.State, InitContract.Effect>() {
    override fun reduce(
        currentState: InitContract.State,
        mutation: InitContract.Mutation
    ): ReduceResult<InitContract.State, InitContract.Effect> {
        return when (mutation) {
            InitContract.Mutation.InitComplete -> stateWithEffects(
                newState = currentState.copy(isInitialized = true),
                effectList = listOf(InitContract.Effect.NavigateToMain)
            )
        }
    }
}