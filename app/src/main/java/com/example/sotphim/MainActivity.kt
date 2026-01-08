package com.example.sotphim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sotphim.ui.theme.SOTPHIMTheme
import com.example.sotphim.viewmodel.moviedetailviewmodel.MovieDetailViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SOTPHIMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 1. Khởi tạo ViewModel đúng cách trong context của Compose
    val movieViewModel: MovieDetailViewModel = viewModel()

    val slug = "ngoi-truong-xac-song"

    // 2. LaunchedEffect sẽ chạy khi Composable này được hiển thị lần đầu
    LaunchedEffect(slug) {
         movieViewModel.fetchMovieDetail(slug)
    }

    // Hiển thị giao diện dựa trên kết quả từ ViewModel
    Text(
        text = "Đang tải phim: $slug",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SOTPHIMTheme {
        Greeting("Android")
    }
}