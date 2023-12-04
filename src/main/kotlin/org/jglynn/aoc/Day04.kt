package org.jglynn.aoc

import kotlin.math.pow

class Day04(private val input: List<String>) {

    fun solvePart2(): Int =
        input.size

    fun solvePart1(): Int {
        val score = input.sumOf {
            val (numbers, winners) = parseCard(it)
            val matches = numbers.intersect(winners)
            when {
                matches.size == 1 -> 1
                matches.size > 1 -> 2.0.pow((matches.size - 1).toDouble()).toInt()
                else -> 0
            }
        }
        println("score = $score")
        return score
    }

    private fun parseCard(card : String): Pair<List<Int>,Set<Int>> {
        val (numbers, winners) = card.substringAfter(":").split("|")
        return numbers.toIntList() to winners.toIntList().toSet()
    }

    private fun String.toIntList(): List<Int> =
        this.trim().split("\\s+".toRegex()).map { it.toInt() }

}
