package org.jglynn.aoc

import kotlin.math.pow

class Day04(private val input: List<String>) {

    fun solvePart1(): Int {
        val scores = calculateScores(input)
        return scores.sumOf { it.second }
    }

    fun solvePart2(): Int {
        val scores = calculateScores(input)
        val allMatches = scores.map { it.first }
        val cards = IntArray(allMatches.size) { 1 }
        allMatches.forEachIndexed { index, score ->
            repeat(score) {
                cards[index+it+1] += cards[index]
            }
        }
        return cards.sum()
    }

    private fun calculateScores(cards : List<String>): List<Pair<Int,Int>> {
        return cards.map { card ->
            val (numbers, winners) = parseCard(card)
            val matches = numbers.intersect(winners)
            matches.size to 2.0.pow((matches.size - 1).toDouble()).toInt()
        }
    }

    private fun parseCard(card : String): Pair<List<Int>,Set<Int>> {
        val (numbers, winners) = card.substringAfter(":").split("|")
        return numbers.toIntList() to winners.toIntList().toSet()
    }

    private fun String.toIntList(): List<Int> =
        this.trim().split("\\s+".toRegex()).map { it.toInt() }

}
