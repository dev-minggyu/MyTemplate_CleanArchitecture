package com.example.core.repository.di

import com.example.core.repository.exam.ExamRepositoryImpl
import com.example.domain.repository.ExamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindExamRepository(examRepositoryImpl: ExamRepositoryImpl): ExamRepository
} 