package com.kotlin.news_api.domain.repository

import androidx.lifecycle.LiveData
import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.data.utils.Resource
import kotlinx.coroutines.flow.Flow


interface NewsRepository {
    suspend fun getNewsHeadlines(country:String,page:Int): Resource<APIResponse>
    suspend fun getSearchedNews(searchQueryString: String): Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    suspend fun getSavedNews(): Flow<List<Article>>
}