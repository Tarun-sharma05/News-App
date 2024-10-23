package com.example.khabarinewsapp.Ui_layer.Screens

import android.icu.text.CaseMap.Title
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.khabarinewsapp.R
import com.example.khabarinewsapp.Ui_layer.ViewModel.newsViewModel

@Composable
fun HomeScreenUI(modifier: Modifier = Modifier, viewModel: newsViewModel){
      val data = viewModel.data.value?.articles!!
     //  val showDown = data?.articles?: emptyList()
      LazyColumn {
           items(data){
               cardItems(
                   Title = it.title?: "Title not available",
                   Discription = it.description?: "Description not available",
                   UrlToImage = it.urlToImage?: ""

               )
           }
      }
}

@Composable
fun cardItems(
    Title: String,
    Discription: String ,
    UrlToImage: String,
    ){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
          Row(modifier = Modifier.fillMaxSize()
              .padding(8.dp)
              .height(100.dp),
              verticalAlignment = Alignment.CenterVertically
          ){
              SubcomposeAsyncImage(
                  model = UrlToImage,
                  loading = {
                      CircularProgressIndicator()
                  },
                  contentDescription = ""
              )

              Column() {
                  Text(text =  Title)
                  Text(text = Discription)
              }
          }
    }
}