package com.kotlin.news_api.data.repository.dataSource

import com.kotlin.news_api.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun  getTopHeadLines(country:String ,page:Int):Response<APIResponse>
}