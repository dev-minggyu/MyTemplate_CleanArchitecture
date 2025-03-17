package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.database.exam.ExamDao
import com.example.core.database.model.ExamEntity

@Database(entities = [ExamEntity::class], version = 1, exportSchema = false)
abstract class ExamDatabase : RoomDatabase() {
    abstract fun examDao(): ExamDao

    companion object {
        const val DB_FILE_NAME = "exam.db"
    }
} 