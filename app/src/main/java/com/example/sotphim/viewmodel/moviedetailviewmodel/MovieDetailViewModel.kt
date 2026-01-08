package com.example.sotphim.viewmodel.moviedetailviewmodel

import android.util.Log
import android.view.View
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sotphim.model.MovieDetailResponse
import com.example.sotphim.repository.MovieRepository
import com.example.sotphim.retrofit.RetrofitClient
import com.example.sotphim.viewmodel.authviewmodel.AuthState
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

sealed class MovieDetailState {
    object Loading : MovieDetailState()
    data class Success(val movieResponse: MovieDetailResponse) : MovieDetailState()
    data class Error(val message: String) : MovieDetailState()
}

class MovieDetailViewModel(
    private val repository: MovieRepository = MovieRepository(
        apiService = RetrofitClient.instance,
    )
) : ViewModel() {


    var uiState by mutableStateOf<MovieDetailState>(MovieDetailState.Loading)
        private set

    fun fetchMovieDetail (slug : String) {
        viewModelScope.launch {
            try {
                val response = repository.getMovieDetail(slug)
                Log.d("MOVIE_TEST", "Dữ liệu trả về: ${response.movie.name}")
                Log.d("MOVIE_TEST", "Số lượng tập: ${response.episodes[0].server_data[0].name}")
                uiState = MovieDetailState.Success(response)
            }
            catch (e : Exception) {
                uiState = MovieDetailState.Error(e.localizedMessage ?: "Lỗi không xác định")
            }
        }
    }
}