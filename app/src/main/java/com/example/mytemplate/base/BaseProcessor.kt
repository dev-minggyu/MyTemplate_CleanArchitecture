package com.example.mytemplate.base

import com.example.mytemplate.base.contract.UiEvent
import com.example.mytemplate.base.contract.UiMutation
import kotlinx.coroutines.flow.Flow

abstract class BaseProcessor<Event : UiEvent, Mutation : UiMutation> {
    abstract fun process(event: Event): Flow<Mutation>
}