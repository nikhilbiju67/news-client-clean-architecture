package com.kotlin.news_api.presentation.di

import android.app.Application
import com.kotlin.news_api.domain.use_case.GetNewsHeadLineUseCase
import com.kotlin.news_api.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun providesNewsViewModelFactory(
        app: Application,
        getNewsHeadLineUseCase: GetNewsHeadLineUseCase
    ): NewsViewModelFactory {
       return NewsViewModelFactory(app, getNewsHeadLineUseCase);
    }
}