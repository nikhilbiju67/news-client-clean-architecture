package com.kotlin.news_api.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlin.news_api.data.model.APIResponse
import com.kotlin.news_api.data.utils.Resource
import com.kotlin.news_api.domain.use_case.GetNewsHeadLineUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    val getNewsHeadLineUseCase: GetNewsHeadLineUseCase,

) : AndroidViewModel(app) {
    val newsHeadLines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    fun getNewsHeadLines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        if (isNetworkAvailable(app)) {
            newsHeadLines.postValue(Resource.Loading());
            val apiResponse = getNewsHeadLineUseCase.execute(country, page);
            newsHeadLines.postValue(apiResponse);
        } else {
            newsHeadLines.postValue(Resource.Error("Internet is not available"))
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) {
            return false
        }

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}