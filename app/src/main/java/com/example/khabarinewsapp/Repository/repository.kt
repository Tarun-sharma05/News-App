package com.example.khabarinewsapp.Repository

import com.example.khabarinewsapp.Network.Responce.NewsModel
import com.example.khabarinewsapp.Network.apiProvider
import retrofit2.Response

class repository {
         suspend fun getNewsRepo(): Response<NewsModel> {
            return apiProvider.provideApi().getNews()
         }
}