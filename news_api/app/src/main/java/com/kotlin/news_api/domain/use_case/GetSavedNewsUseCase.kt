package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.BuildConfig
import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews();
    }
}