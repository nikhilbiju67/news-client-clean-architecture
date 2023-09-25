package com.kotlin.news_api.data.repository

import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.model.Article
import com.kotlin.news_api.data.repository.dataSource.NewsRemoteDataSource
import com.kotlin.news_api.data.utils.Resource
import com.kotlin.news_api.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val remoteDataSource: NewsRemoteDataSource) : NewsRepository {

    override suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(remoteDataSource.getTopHeadLines(country = country, page = page))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result);
            }
        } else {
            return Resource.Error(response.message());
        }
        return Resource.Error("error");
    }

    override suspend fun getSearchedNews(searchQueryString: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}