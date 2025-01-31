package com.example.evaluationre.api

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("news")
    suspend fun getNews(
        @Query("access_key") apiKey: String = Constants.API_KEY,
        @Query("sources") sources: String,
        @Query("countries") countries: String
    ): NewsEntity
}