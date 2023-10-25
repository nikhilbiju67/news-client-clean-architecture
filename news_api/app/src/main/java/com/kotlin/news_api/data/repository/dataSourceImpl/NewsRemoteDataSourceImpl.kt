package com.kotlin.news_api.data.repository.dataSourceImpl

import com.kotlin.news_api.data.api.NewsApiService
import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsApiService: NewsApiService) : NewsRemoteDataSource {

    override suspend fun getTopHeadLines(country: String, page: Int): Response<APIResponse> {
        return newsApiService.getTopHeadLines(country, page);
    }
}