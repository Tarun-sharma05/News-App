package com.example.khabarinewsapp.Network

import com.example.khabarinewsapp.Network.Responce.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface apiServices {

    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country: String="us",
        @Query("category") category: String="business",
        @Query("apiKey") apiKey: String="17e269cee7b4495ab9f1766707ffe7b1"
    ): Response<NewsModel>
}