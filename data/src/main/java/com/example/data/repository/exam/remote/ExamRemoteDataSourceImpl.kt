package com.example.data.repository.exam.remote

import com.example.data.api.ApiInterface
import javax.inject.Inject

class ExamRemoteDataSourceImpl @Inject constructor(private val apiInterface: ApiInterface) : ExamRemoteDataSource {

}