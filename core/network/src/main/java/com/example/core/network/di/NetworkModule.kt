package com.example.core.network.di

import com.example.core.network.ApiInterface
import com.example.core.network.datasource.exam.ExamRemoteDataSource
import com.example.core.network.datasource.exam.ExamRemoteDataSourceImpl
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(ApiInterface.BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient.build())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
    
    @Provides
    @Singleton
    fun provideExamRemoteDataSource(apiInterface: ApiInterface): ExamRemoteDataSource {
        return ExamRemoteDataSourceImpl(apiInterface)
    }
} 