package com.example.data.di

import com.example.data.repository.exam.ExamRepositoryImpl
import com.example.data.repository.exam.local.ExamLocalDataSource
import com.example.data.repository.exam.remote.ExamRemoteDataSource
import com.example.data.repository.exam.remote.ExamRemoteDataSourceImpl
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

    @Binds
    @Singleton
    abstract fun bindExamRemoteDataSource(examRemoteDataSourceImpl: ExamRemoteDataSourceImpl): ExamRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindExamLocalDataSource(examLocalDataSource: ExamLocalDataSource): ExamLocalDataSource
}