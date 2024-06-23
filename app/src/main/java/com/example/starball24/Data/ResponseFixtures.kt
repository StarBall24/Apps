package com.example.starball24.Data

data class ResponseFixtures(
    val response: List<response>
)
data class response(
    val teams: teams,
    val fixture: fixture,
    val goals: goals
)

data class fixture(
    val date:String,
    val id:Int
)

data class teams(
    val home : home,
    val away: away
)

data class away(
    val id:Int,
    val name:String,
    val logo:String,
    val winner:Boolean
)
data class home(
    val id:Int,
    val name:String,
    val logo:String,
    val winner:Boolean
)
data class goals(
    val home:Int,
    val away:Int
)