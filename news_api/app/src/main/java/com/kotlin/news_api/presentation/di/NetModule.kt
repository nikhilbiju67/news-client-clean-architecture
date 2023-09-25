package com.kotlin.news_api.presentation.di

import com.kotlin.news_api.BuildConfig
import com.kotlin.news_api.data.api.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
       return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BuildConfig.BASE_URL).build();
    }
   @Provides
   @Singleton
    fun providesNewsAPIService(retrofit: Retrofit):NewsApiService
    {
        return retrofit.create(NewsApiService::class.java)

    }

}