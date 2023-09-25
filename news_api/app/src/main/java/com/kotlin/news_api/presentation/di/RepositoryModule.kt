package com.kotlin.news_api.presentation.di

import com.kotlin.news_api.data.repository.NewsRepositoryImpl
import com.kotlin.news_api.data.repository.dataSource.NewsRemoteDataSource
import com.kotlin.news_api.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun providesNewsRepository(remoteDataSource: NewsRemoteDataSource): NewsRepository {
      return  NewsRepositoryImpl(remoteDataSource)
    }
}