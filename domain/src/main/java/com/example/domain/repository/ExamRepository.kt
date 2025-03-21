package com.example.domain.repository

import com.example.domain.model.Exam
import kotlinx.coroutines.flow.Flow

interface ExamRepository {
    fun getExams(): Flow<List<Exam>>

    fun getExamById(id: String): Flow<Exam?>

    suspend fun refreshExams()

    suspend fun refreshExam(id: String)
}