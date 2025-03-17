package com.example.core.repository.exam

import com.example.core.repository.exam.local.ExamLocalDataSource
import com.example.core.repository.exam.remote.ExamRemoteDataSource
import com.example.domain.repository.ExamRepository
import javax.inject.Inject

class ExamRepositoryImpl @Inject constructor(
    private val examRemoteDataSource: ExamRemoteDataSource,
    private val examLocalDataSource: ExamLocalDataSource,
) : ExamRepository {

} 