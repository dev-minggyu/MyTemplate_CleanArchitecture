package com.template.app.base

import com.template.app.base.contract.UiAction
import com.template.app.base.contract.UiMutation
import kotlinx.coroutines.flow.Flow

abstract class BaseProcessor<Event : UiAction, Mutation : UiMutation> {
    abstract fun process(event: Event): Flow<Mutation>
}