package com.example.starball24.ApiServices

import com.example.starball24.Data.RequestBody
import com.example.starball24.Data.ResponseFixtures
import com.example.starball24.Data.ResponsePredict
import com.example.starball24.Data.ResponseStanding
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {
    @Headers(
        "X-RapidAPI-Key: a21e5084a474cf337bd34fc70b4cbdbe",
        "X-RapidAPI-Host: v3.football.api-sports.io"
    )
    @GET("standings")
    suspend fun getStanding(
        @Query("league") league:Int,
        @Query("season") season:Int
    ): ResponseStanding
    @Headers(
        "X-RapidAPI-Key: a21e5084a474cf337bd34fc70b4cbdbe",
        "X-RapidAPI-Host: v3.football.api-sports.io"
    )
    @GET("fixtures")
    suspend fun getMatch(
        @Query("league") league: Int,
        @Query("season") season: Int,
        @Query("date") date: String
    ): ResponseFixtures

    @POST("predict")
    suspend fun predict(
        @Body requestBody: RequestBody
    ):ResponsePredict

}