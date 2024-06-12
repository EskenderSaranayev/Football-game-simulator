package com.example.a10_matches

import kotlin.math.abs
import kotlin.random.Random

data class MatchResult(val team1: String, val team2: String, var score1: Int, var score2: Int)
{  fun goalDifference(): Int = abs(score1 - score2)  }

fun main(){
    val matchResults = mutableListOf<MatchResult>()
    val team1 = "Barcelona"
    val team2 = "Real Madrid"

    for (i in 1..10) {
        val score1 = Random.nextInt(0, 6) //
        val score2 = Random.nextInt(0, 6) //


        matchResults.add(MatchResult(team1, team2, score1, score2))
    }
    println("Match Results:")
    matchResults.forEach {matchResult ->
        println("${matchResult.team1} ${matchResult.score1} : ${matchResult.score2} ${matchResult.team2}")
    }


    val nonDrawMatches = matchResults.filter { it.score1 != it.score2 }
    println("Match Results after removing draws:")
    nonDrawMatches.forEach { println("$team1 ${it.score1} : ${it.score2} $team2") }

    val maxGoalDifferenceSet = nonDrawMatches.maxByOrNull { it.goalDifference() }?.let { setOf(it) }?: setOf()
    println("\nGames with the biggest margin of victory")
    maxGoalDifferenceSet.forEach { println("$team1 ${it.score1} : ${it.score2} $team2 ")  }

}


