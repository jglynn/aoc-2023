package org.jglynn.aoc

class Day08(private val input: List<String>) {

    fun solvePart1(): Int {

        val instructions = input.first().asSequence()

        val nodes = input.drop(2).associate {
             it.substring(0,3) to Pair( it.substring(7, 10),  it.substring(12, 15)) }

        var steps = 0
        var position = nodes.getOrDefault("AAA", end )

        while ( true ) for ( instruction in instructions ) {
            steps++
            if (position.next(instruction) == "ZZZ") return steps
            position = nodes.getOrDefault(position.next(instruction), end )
        }
    }

    private val end = Pair("ZZZ", "ZZZ")

    private fun Pair<String, String>.next(c : Char): String =
        if ('L'.compareTo(c) == 0) { this.first } else { this.second }

    fun solvePart2(): Int {
        return 0
    }

}

