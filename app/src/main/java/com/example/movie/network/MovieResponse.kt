package com.example.movie.network

data class MovieResponse(
    val page: Int,
    val results: List<MovieProperties>,
)

