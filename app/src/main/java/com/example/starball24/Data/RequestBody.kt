package com.example.starball24.Data

data class RequestBody(
    val home_team_code:String,
    val away_team_code:String,
    val hour:Int,
    val day_code:String
)
