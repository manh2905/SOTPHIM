package com.example.sotphim.model

import android.provider.Settings

data class User (
    val uid : String ,
    val displayName : String ,
    val email : String ,
    val photoUrl : String ,
    val createAt : Long = System.currentTimeMillis() ,
    val favourites : List<String> = emptyList(),
    val watchedTime : Map<String, Int> = emptyMap()
)
