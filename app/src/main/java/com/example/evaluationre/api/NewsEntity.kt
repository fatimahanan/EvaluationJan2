package com.example.evaluationre.api

import com.google.gson.annotations.SerializedName

data class NewsEntity(
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("data")
    val data: List<Article>
) {
    data class Pagination(
        @SerializedName("limit")
        val limit: Int,
        @SerializedName("offset")
        val offset: Int,
        @SerializedName("count")
        val count: Int,
        @SerializedName("total")
        val total: Int
    )

    data class Article(
        @SerializedName("author")
        val author: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("url")
        val url: String?,
        @SerializedName("source")
        val source: String?,
        @SerializedName("image")
        val image: String?,
        @SerializedName("category")
        val category: String?,
        @SerializedName("language")
        val language: String?,
        @SerializedName("country")
        val country: String?,
        @SerializedName("published_at")
        val publishedAt: String?
    )
}
