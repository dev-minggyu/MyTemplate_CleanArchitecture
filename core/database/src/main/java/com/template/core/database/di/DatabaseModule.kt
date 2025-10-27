package com.template.core.database.di

import androidx.room.Room
import com.template.core.database.ExamDatabase
import com.template.core.database.datasource.exam.ExamLocalDataSource
import com.template.core.database.datasource.exam.ExamLocalDataSourceImpl
import com.template.core.database.exam.ExamDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<ExamDatabase> {
        Room.databaseBuilder(
            androidContext(),
            ExamDatabase::class.java,
            ExamDatabase.DB_FILE_NAME
        ).build()
    }

    single<ExamDao> {
        get<ExamDatabase>().examDao()
    }
    
    single<ExamLocalDataSource> {
        ExamLocalDataSourceImpl(get())
    }
}