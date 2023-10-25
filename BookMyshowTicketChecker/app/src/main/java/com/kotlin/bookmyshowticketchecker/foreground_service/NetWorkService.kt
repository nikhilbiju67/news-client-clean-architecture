package com.kotlin.bookmyshowticketchecker.foreground_service

import android.util.Log
import okhttp3.ResponseBody

class NetWorkService {
    val retrofit = RetrofitBuilder().retrofit;
    val apiService = retrofit.create(ApiService::class.java)

    suspend fun getData(): ResponseBody {
        var response = apiService.getRawStringResponse();
       Log.d("RESPONSEBOOKMY SHOW",response.string());
        return  response


    }
}
