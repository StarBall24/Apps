package com.example.starball24.Data

data class ResponseStanding(
    val response:List<LeagueResponse>
)

data class LeagueResponse (
    val league: League
)

data class TeamStanding(
    val rank: Int,
    val team: Team,
    val points: Int,
    val all:Record
)

data class League(
    val id:Int,
    val name:String,
    val season:Int,
    val standings:List<List<TeamStanding>>
)
data class Team(
    val id: Int,
    val name: String,
    val logo: String
)
data class Record(
    val played: Int,
    val win: Int,
    val draw: Int,
    val lose: Int
)
