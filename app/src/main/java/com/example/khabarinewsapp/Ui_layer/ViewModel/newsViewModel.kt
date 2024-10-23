package com.example.khabarinewsapp.Ui_layer.ViewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.khabarinewsapp.Network.Responce.NewsModel
import com.example.khabarinewsapp.Repository.repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class newsViewModel : ViewModel(){

    val repo = repository()
    val data = mutableStateOf<NewsModel?>(null)

    init {
        viewModelScope.launch(Dispatchers.IO){
            getNewsViewModel()
        }
    }

    suspend fun getNewsViewModel(){
          data.value = repo.getNewsRepo().body()
    }
}