package com.example.evaluationre.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evaluationre.api.NewsModel
import com.example.evaluationre.api.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    private val _newsLiveData = MutableLiveData<List<NewsModel>>()
    val newsLiveData: LiveData<List<NewsModel>> = _newsLiveData

    private val newsRepository = NewsRepository()

    fun fetchNews(source: String, country: String) {
        viewModelScope.launch {
            try {
                val news = fetchNewsFromApi(source, country)
                _newsLiveData.postValue(news)
            } catch (e: Exception) {
                _newsLiveData.postValue(emptyList())
            }
        }
    }

    private suspend fun fetchNewsFromApi(source: String, country: String): List<NewsModel> {
        val newsEntity = newsRepository.getNewsInfo(source, country)

        return newsEntity
    }
}