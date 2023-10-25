package com.kotlin.bookmyshowticketchecker.foreground_service

import okhttp3.ResponseBody
import retrofit2.http.GET


interface ApiService {
    @GET("/kochi/movies/leo/ET00351731")
    suspend fun getRawStringResponse(): ResponseBody
}