package com.example.evaluationre.api

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRepository{

    suspend fun getNewsInfo(source: String, country: String): List<NewsModel> {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(NewsAPI::class.java)

//        val response = api.getNews(Constants.API_KEY, source, country)
        val response = api.getNews(
            sources = source,
            countries = country
        )
        return response.toNewsModel()
    }
}

fun NewsEntity.toNewsModel(): List<NewsModel> {
    Log.d("NewsEntity", "Converting ${this.data.size} articles")
    return this.data.map { article ->
        NewsModel(
            title = article.title ?: "No Title",
            description = article.description ?: "No Description"
        )
    }
}




