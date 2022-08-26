package com.example.data.model.exam

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam")
data class ExamEntity(
    @PrimaryKey(autoGenerate = false)
    val exam: String,
)