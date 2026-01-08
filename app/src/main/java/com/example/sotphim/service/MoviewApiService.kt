package com.example.sotphim.service

import com.example.sotphim.model.MovieDetail
import com.example.sotphim.model.MovieDetailResponse
import com.example.sotphim.model.MovieListRespone
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviewApiService {
    @GET("danh-sach/phim-moi-cap-nhat-v2")
    suspend fun getNewMovies(
        @Query("page") page : Int
    ): MovieListRespone

    @GET("phim/{slug}")
    suspend fun getMovieDetail(
        @Path("slug") slug : String
    ) : MovieDetailResponse
}