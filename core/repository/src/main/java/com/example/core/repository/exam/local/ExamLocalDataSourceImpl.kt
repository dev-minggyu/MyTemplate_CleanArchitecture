package com.example.core.repository.exam.local

import com.example.core.database.exam.ExamDao
import javax.inject.Inject

class ExamLocalDataSourceImpl @Inject constructor(private val examDao: ExamDao) : ExamLocalDataSource {

} 