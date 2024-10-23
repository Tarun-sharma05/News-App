package com.example.khabarinewsapp.Network.Responce

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)