package com.template.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.template.core.database.exam.ExamDao
import com.template.core.database.model.ExamEntity

@Database(entities = [ExamEntity::class], version = 1, exportSchema = false)
abstract class ExamDatabase : RoomDatabase() {
    abstract fun examDao(): ExamDao

    companion object {
        const val DB_FILE_NAME = "exam.db"
    }
} 