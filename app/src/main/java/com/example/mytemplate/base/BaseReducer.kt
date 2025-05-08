package com.example.mytemplate.base

import com.example.mytemplate.base.contract.UiEffect
import com.example.mytemplate.base.contract.UiMutation
import com.example.mytemplate.base.contract.UiState

abstract class BaseReducer<Mutation : UiMutation, State : UiState, Effect : UiEffect> {
    data class ReduceResult<State : UiState, Effect : UiEffect>(val newState: State, val effects: List<Effect>)

    abstract fun reduce(currentState: State, mutation: Mutation): ReduceResult<State, Effect>

    protected fun stateWithEffects(
        newState: State,
        effectList: List<Effect> = emptyList()
    ): ReduceResult<State, Effect> = ReduceResult(newState, effectList)
}