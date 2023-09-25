package com.kotlin.news_api.domain.use_case

import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.utils.Resource
import com.kotlin.news_api.domain.repository.NewsRepository

class GetNewsHeadLineUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country:String ,page:Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country,page);
    }

}