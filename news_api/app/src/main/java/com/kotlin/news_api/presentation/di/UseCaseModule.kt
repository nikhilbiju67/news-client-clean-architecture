package com.kotlin.news_api.presentation.di

import com.kotlin.news_api.domain.repository.NewsRepository
import com.kotlin.news_api.domain.use_case.GetNewsHeadLineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetNewsHeadLineUseCase(newsRepository: NewsRepository): GetNewsHeadLineUseCase{
        return  GetNewsHeadLineUseCase(newsRepository = newsRepository);
    }
}
