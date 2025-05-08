package com.example.mytemplate.ui.splash

import com.example.mytemplate.base.BaseProcessor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InitProcessor @Inject constructor() : BaseProcessor<InitContract.Event, InitContract.Mutation>() {
    override fun process(event: InitContract.Event): Flow<InitContract.Mutation> {
        return when (event) {
            InitContract.Event.Initialize -> flow {
                delay(1000)
                emit(InitContract.Mutation.InitComplete)
            }
        }
    }
}