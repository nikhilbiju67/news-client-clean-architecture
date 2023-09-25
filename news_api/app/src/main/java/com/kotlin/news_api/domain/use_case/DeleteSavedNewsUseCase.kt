package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private  val newsRepository: NewsRepository) {
    suspend fun  execute(article: Article)=newsRepository.deleteNews(article)
}