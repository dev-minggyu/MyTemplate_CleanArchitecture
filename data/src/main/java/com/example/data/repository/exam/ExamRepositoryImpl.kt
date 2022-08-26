package com.example.data.repository.exam

import com.example.data.repository.exam.local.ExamLocalDataSource
import com.example.data.repository.exam.remote.ExamRemoteDataSource
import com.example.domain.repository.ExamRepository
import javax.inject.Inject

class ExamRepositoryImpl @Inject constructor(
    private val examRemoteDataSource: ExamRemoteDataSource,
    private val examLocalDataSource: ExamLocalDataSource,
) : ExamRepository {

}