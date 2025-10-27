package com.template.core.network.datasource.exam

import com.template.core.network.model.ExamResponse
import kotlinx.coroutines.flow.Flow

interface ExamRemoteDataSource {
    suspend fun getExams(): Flow<List<ExamResponse>>

    suspend fun getExamById(id: String): Flow<ExamResponse>

    suspend fun createExam(exam: ExamResponse): Flow<ExamResponse>

    suspend fun updateExam(id: String, exam: ExamResponse): Flow<ExamResponse>

    suspend fun deleteExam(id: String): Flow<Boolean>
} 