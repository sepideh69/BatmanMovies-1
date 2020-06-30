package com.yaramobile.batmanmovies.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import ir.sepidstore.clquestion.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

enum class ApiStatus { LOADING, DONE, ERROR ,NOTREFRESH}
private const val BASE_URL = "http://www.omdbapi.com/"


private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()


object TheApi {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java) }
}