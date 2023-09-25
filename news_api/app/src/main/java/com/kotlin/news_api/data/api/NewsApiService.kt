package com.kotlin.news_api.data.api

import com.kotlin.news_api.BuildConfig
import retrofit2.Response;
import retrofit2.http.GET;
import com.kotlin.news_api.data.model.APIResponse
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/top-headlines")
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}