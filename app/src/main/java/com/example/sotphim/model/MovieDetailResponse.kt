package com.example.sotphim.model


data class MovieDetailResponse (
    val status : String,
    val msg : String,
    val movie: MovieDetail,
    val episodes : List<ServerEpisode>
)

data class MovieDetail (
    val _id: String,
    val name: String,
    val slug: String,
    val origin_name: String,
    val content: String,
    val type: String,
    val status: String,
    val poster_url: String,
    val thumb_url: String,
    val trailer_url: String,
    val time: String,
    val episode_current: String,
    val episode_total: String,
    val quality: String,
    val lang: String,
    val year: Int,
    val actor: List<String>,
    val director: List<String>,
    val category: List<Category>,
    val country: List<Country>
)

data class Category(val name: String, val slug: String)
data class Country(val name: String, val slug: String)

data class ServerEpisode (
    val server_name : String,
    val server_data: List<EpisodeData>
)

data class EpisodeData (
    val name : String ,
    val slug : String ,
    val filename : String,
    val link_embed : String,
    val link_m3u8 : String
)