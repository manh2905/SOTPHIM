package com.example.sotphim.model

data class MovieListRespone (
    val status : String,
    val msg : String,
    val movieList : List<MovieItem>
)

data class MovieItem (
    val _id: String,
    val name: String,
    val slug: String,
    val origin_name: String,
    val poster_url: String,
    val thumb_url: String,
    val year: Int,
    val episode_current: String,
)