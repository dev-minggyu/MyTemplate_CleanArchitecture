package com.template.core.repository.di

import com.template.core.repository.exam.ExamRepositoryImpl
import com.template.domain.repository.ExamRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ExamRepository> {
        ExamRepositoryImpl(get(), get())
    }
}