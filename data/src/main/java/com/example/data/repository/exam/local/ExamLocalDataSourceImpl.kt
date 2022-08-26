package com.example.data.repository.exam.local

import com.example.data.db.exam.ExamDao
import javax.inject.Inject

class ExamLocalDataSourceImpl @Inject constructor(private val examDao: ExamDao) : ExamLocalDataSource {

}