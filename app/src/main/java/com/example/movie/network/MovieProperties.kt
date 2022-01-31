package com.example.movie.network

import com.squareup.moshi.Json

data class MovieProperties (
    @Json(name = "img_src") val imgSrcUrl: String,
    val id: String,
    val detail: String,
    val rating: String,
    val releaseDate: String,
)