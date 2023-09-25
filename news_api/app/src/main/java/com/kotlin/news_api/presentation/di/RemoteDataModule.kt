package com.kotlin.news_api.presentation.di

import com.kotlin.news_api.data.api.NewsApiService
import com.kotlin.news_api.data.repository.dataSource.NewsRemoteDataSource
import com.kotlin.news_api.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {
    @Provides
    @Singleton
    fun providesRemoteDataSource(newsApiService: NewsApiService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsApiService = newsApiService);
    }


}