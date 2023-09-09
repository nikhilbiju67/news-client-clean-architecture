package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.domain.repository.NewsRepository

class GetNewsHeadLineUseCase(private val newsRepository: NewsRepository) {
}