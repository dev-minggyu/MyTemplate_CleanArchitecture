package com.template.app.base

import com.template.app.base.contract.UiEvent
import com.template.app.base.contract.UiMutation
import com.template.app.base.contract.UiState

abstract class BaseReducer<Mutation : UiMutation, State : UiState, Effect : UiEvent> {
    data class ReduceResult<State : UiState, Effect : UiEvent>(val newState: State, val effects: List<Effect>)

    abstract fun reduce(currentState: State, mutation: Mutation): ReduceResult<State, Effect>

    protected fun stateWithEffects(
        newState: State,
        effectList: List<Effect> = emptyList()
    ): ReduceResult<State, Effect> = ReduceResult(newState, effectList)
}