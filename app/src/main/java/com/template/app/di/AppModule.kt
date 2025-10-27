package com.template.app.di

import com.template.app.ui.main.MainProcessor
import com.template.app.ui.main.MainReducer
import com.template.app.ui.main.MainViewModel
import com.template.app.ui.splash.InitProcessor
import com.template.app.ui.splash.InitReducer
import com.template.app.ui.splash.InitViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // Processors
    factory { InitProcessor() }
    factory { MainProcessor() }
    
    // Reducers
    factory { InitReducer() }
    factory { MainReducer() }
    
    // ViewModels
    viewModel { InitViewModel(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
}