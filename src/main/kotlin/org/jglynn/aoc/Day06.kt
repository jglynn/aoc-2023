package org.jglynn.aoc

import kotlin.math.pow

class Day06(private val input: List<String>) {

    fun solvePart1(): Int {

        val times = parse(input.first())
        val distances = parse(input.last())

        val winProduct = times.mapIndexed{ game, time ->
            (1..time)
                .map { it * (time - it) }
                .count { it > distances[game] }
        }.reduce { acc, element -> acc * element }

        return winProduct
    }

    fun solvePart2(): Int {
        return input.size
    }

    private fun parse(line: String) =
        line.replace("\\s+".toRegex(), ",")
            .substringAfter(":,")
            .split(",")
            .map { it.trim().toInt() }

}
