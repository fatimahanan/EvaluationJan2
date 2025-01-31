package com.example.evaluationre.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluationre.api.NewsModel
import com.example.evaluationre.api.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewsViewModel : ViewModel() {
    private val _newsLiveData = MutableLiveData<List<NewsModel>>()
    val newsLiveData: LiveData<List<NewsModel>> = _newsLiveData
    private var job: Job? = null

    fun fetchNews(source: String, country: String) {

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {
            val newsRepository = NewsRepository()
            val news = newsRepository.getNewsInfo(source, country)
            Log.d("NewsViewModel", "Fetched ${news.size} news items")
            withContext(Main){
                _newsLiveData.postValue(news)
            }
        }
    }

}