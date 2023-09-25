package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.data.utils.Resource
import com.kotlin.news_api.domain.repository.NewsRepository

class GetSearchedUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQueryString: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQueryString);
    }
}