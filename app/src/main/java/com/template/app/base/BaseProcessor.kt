package com.template.app.base

import com.template.app.base.contract.UiAction
import com.template.app.base.contract.UiMutation
import kotlinx.coroutines.flow.Flow

abstract class BaseProcessor<Action : UiAction, Mutation : UiMutation> {
    abstract fun process(action: Action): Flow<Mutation>
}