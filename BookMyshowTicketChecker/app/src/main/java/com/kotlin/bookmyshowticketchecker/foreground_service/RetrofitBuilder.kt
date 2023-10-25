package com.kotlin.bookmyshowticketchecker.foreground_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://in.bookmyshow.com")
        .addConverterFactory(GsonConverterFactory.create()) // Use ScalarsConverterFactory for raw strings
        .build()

}