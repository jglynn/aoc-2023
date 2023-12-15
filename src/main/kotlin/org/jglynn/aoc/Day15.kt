package org.jglynn.aoc

class Day15(private val input: String) {

    fun solvePart1(): Int {
        return input.split(",").sumOf { it.hash() }
    }

    private fun String.hash(): Int =
        this.asSequence().fold(0){ curr, next ->
            (curr + next.code) * 17 % 256
        }

    fun solvePart2(): Int {
        return 0
    }

}