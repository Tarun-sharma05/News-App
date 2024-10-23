package com.example.khabarinewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.khabarinewsapp.Ui_layer.Screens.HomeScreenUI
import com.example.khabarinewsapp.Ui_layer.ViewModel.newsViewModel
import com.example.khabarinewsapp.ui.theme.KhabariNewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val viewModel : newsViewModel by viewModels()
        setContent {
            KhabariNewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    test(viewModel =   viewModel)


                }
            }
        }
    }
}

@Composable
fun  test(viewModel: newsViewModel){
    if (viewModel.data.value == null){
        Text(text = "Loading")
    }else{
        HomeScreenUI(viewModel = viewModel)
    }
}

