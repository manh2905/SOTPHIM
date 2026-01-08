package com.example.sotphim.repository

import com.example.sotphim.service.MoviewApiService

class MovieRepository(private val apiService : MoviewApiService) {
    suspend fun getNewMovies (page : Int) = apiService.getNewMovies(page)

    suspend fun  getMovieDetail (slug : String) = apiService.getMovieDetail(slug)
}