package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.db.exam.ExamDao
import com.example.data.model.exam.ExamEntity

@Database(entities = [ExamEntity::class], version = 1, exportSchema = false)
abstract class ExamDatabase : RoomDatabase() {
    abstract fun examDao(): ExamDao

    companion object {
        const val DB_FILE_NAME = "exam.db"
    }
}