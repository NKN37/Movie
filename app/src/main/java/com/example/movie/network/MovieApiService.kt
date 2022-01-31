package com.example.movie.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL =
    "https://api.themoviedb.org/3/discover/movie?sort_by=popularity.desc&api_key=a49cf8a5f42225880f049917a2262e81"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MovieApiService {
    /**
     * Returns a Coroutine [List] of [MovieProperties] which can be fetched with await() if
     * in a Coroutine scope.
     * The @GET annotation indicates that the "detail" endpoint will be requested with the GET
     * HTTP method
     */
    @GET("detail")
    suspend fun getProperties(): List<MovieProperties>
}

object MovieApi {
    val retrofitService: MovieApiService by lazy { retrofit.create(MovieApiService::class.java) }
}