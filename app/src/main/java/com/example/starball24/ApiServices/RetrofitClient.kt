package com.example.starball24.ApiServices

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object FootballIntance{
    private val BASE_URL = "https://v3.football.api-sports.io/"
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)
}
object PredictionClient{
    private val URL_PREDICTIONS = "https://starball24-backend-33cfcog27q-et.a.run.app/"
    val retrofit = Retrofit.Builder()
        .baseUrl(URL_PREDICTIONS)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetrofitService::class.java)
}