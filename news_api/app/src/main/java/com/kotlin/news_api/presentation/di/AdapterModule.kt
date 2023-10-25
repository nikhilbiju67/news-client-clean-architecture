package com.kotlin.news_api.presentation.di

import com.kotlin.news_api.presentation.adapter.NewsAdapter
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AdapterModule {
    fun provideNewsAdapter():NewsAdapter{
        return NewsAdapter();
    }
}