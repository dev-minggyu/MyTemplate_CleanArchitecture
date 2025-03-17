package com.example.core.database.datasource.exam

import com.example.core.database.exam.ExamDao
import com.example.core.database.model.ExamEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExamLocalDataSourceImpl @Inject constructor(
    private val examDao: ExamDao
) : ExamLocalDataSource {
    
    override fun getExams(): Flow<List<ExamEntity>> {
        return examDao.getExams()
    }
    
    override fun getExamById(id: String): Flow<ExamEntity?> {
        return examDao.getExamById(id)
    }
    
    override suspend fun saveExam(exam: ExamEntity) {
        examDao.insertExam(exam)
    }
    
    override suspend fun saveExams(exams: List<ExamEntity>) {
        examDao.insertExams(exams)
    }
    
    override suspend fun deleteExamById(id: String) {
        examDao.deleteExamById(id)
    }
    
    override suspend fun deleteAllExams() {
        examDao.deleteAllExams()
    }
}