package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private  val newsRepository: NewsRepository) {
}