package com.example.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.core.database.ExamDatabase
import com.example.core.database.datasource.exam.ExamLocalDataSource
import com.example.core.database.datasource.exam.ExamLocalDataSourceImpl
import com.example.core.database.exam.ExamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideExamDatabase(@ApplicationContext context: Context): ExamDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            ExamDatabase::class.java, ExamDatabase.DB_FILE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideExamDao(appDB: ExamDatabase): ExamDao {
        return appDB.examDao()
    }
    
    @Singleton
    @Provides
    fun provideExamLocalDataSource(examDao: ExamDao): ExamLocalDataSource {
        return ExamLocalDataSourceImpl(examDao)
    }
} 