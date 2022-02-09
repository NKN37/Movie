package com.example.movie.network

import com.squareup.moshi.Json

data class MovieProperties(
    @Json(name = "poster_path") val imgSrcUrl: String,
    @Json(name = "original_title") val originalTitle: String,
    @Json(name = "genre_ids") val genreIds: List<Int>,
    @Json(name = "release_date") val releaseDate: String,

    //    val id: String,
    //    val rating: String,
)

