package org.jglynn.aoc

import kotlin.math.pow

class Day04(private val input: List<String>) {

    fun solvePart1(): Int {
        val scores = calculateScores(input)
        return scores.sumOf { it.second }
    }

    fun solvePart2(): Int {
        val scores = calculateScores(input)
        val games = mutableListOf<Int>()
        repeat(scores.size) { index ->
            pullCards(games, index, scores)
        }
        //println(games.groupingBy{it}.eachCount())
        return games.size
    }

    private fun pullCards( acc : MutableList<Int>, game : Int, scores : List<Pair<Int,Int>>) {
        acc.add(game)
        val winners = scores[game].first
        if (winners > 0) {
            repeat (winners) { index ->
                pullCards(acc,game + index + 1, scores)
            }
        }
    }

    private fun calculateScores(cards : List<String>) =
        input.map { card ->
            val (numbers, winners) = parseCard(card)
            val matches = numbers.intersect(winners)
            matches.size to when {
                matches.size == 1 -> 1
                matches.size > 1 -> 2.0.pow((matches.size - 1).toDouble()).toInt()
                else -> 0
            }
        }

    private fun parseCard(card : String): Pair<List<Int>,Set<Int>> {
        val (numbers, winners) = card.substringAfter(":").split("|")
        return numbers.toIntList() to winners.toIntList().toSet()
    }

    private fun String.toIntList(): List<Int> =
        this.trim().split("\\s+".toRegex()).map { it.toInt() }

}
