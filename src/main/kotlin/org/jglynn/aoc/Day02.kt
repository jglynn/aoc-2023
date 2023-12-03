package org.jglynn.aoc

class Day02(private val input: List<String>) {

    companion object {
        const val MAX_RED = 12
        const val MAX_GREEN = 13
        const val MAX_BLUE = 14
    }

    fun solvePart1(): Int {
        val parsed = input.mapIndexed { index, row -> parseGames(index+1, row) }
        val validGameSum = parsed
            .filter { it.reds.max() <= MAX_RED && it.greens.max() <= MAX_GREEN && it.blues.max() <= MAX_BLUE }
            .sumOf { it.number };
        println(validGameSum)
        return validGameSum
    }

    fun solvePart2(): Int {
        println(input.size)
        return input.size
    }

    data class Game(var number: Int,
                    var greens: MutableList<Int>,
                    var blues: MutableList<Int>,
                    var reds: MutableList<Int>){
        fun score(green: Int, blue: Int, red: Int) {
            greens.add(green)
            blues.add(blue)
            reds.add(red)
        }
    }

    private fun parseGames(index: Int, row : String): Game {
        val game = Game(index, mutableListOf<Int>(), mutableListOf<Int>(), mutableListOf<Int>())
        row.split(":").last()
            .split(";")
            .map { gameData ->
                val counts = gameData.split(", ")
                    .map { it.trim().split(" ") }
                    .associate { it.last() to it.first().toInt() }
                val green = counts["green"] ?: 0
                val blue = counts["blue"] ?: 0
                val red = counts["red"] ?: 0
                game.score(green, blue, red)
            }
        return game
    }

}
