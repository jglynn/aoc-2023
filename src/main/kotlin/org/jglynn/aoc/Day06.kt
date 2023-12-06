package org.jglynn.aoc

class Day06(private val input: List<String>) {

    fun solvePart1(): Int {
        val times = parse(input.first()).map { it.toLong() }
        val distances = parse(input.last()).map { it.toLong() }
        return times
            .mapIndexed { game, time -> countWinners(time, distances[game]) }
            .reduce { acc, element -> acc * element }
    }

    fun solvePart2(): Int {
        val time = parse(input.first()).joinToString("").toLong()
        val distance = parse(input.last()).joinToString("").toLong()
        return countWinners(time, distance)
    }

    private fun countWinners(time: Long, distance: Long): Int =
        (1..<time).count { it * (time - it) > distance }

    private fun parse(line: String) =
        line.replace("\\s+".toRegex(), " ")
            .substringAfter(": ")
            .split(" ")
            .map { it.trim() }

}
