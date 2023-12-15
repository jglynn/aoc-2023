package org.jglynn.aoc

class Day14(private val input: List<String>) {

    fun solvePart1(): Int {
        val transposedInput = input.map { it.chunked(1) }.transpose()
        val shiftedStones = transposedInput.map { shiftStones(it) }
        return shiftedStones.sumOf {
            it.reversed().mapIndexed { index, item ->
                if (item == STONE) {  index + 1 }
                else { 0 }
            }.sum()
        }
    }

    fun solvePart2(): Int {
        return 0
    }

    private fun shiftStones(list: List<String>): List<String> {
        val sortedList = list.toMutableList()
        for (i in list.indices) {
            if (sortedList[i] == SPACE) {
                val remaining = sortedList.subList(i, list.size)
                if (!remaining.contains(STONE)) { break }
                val nextStone = remaining.indexOfFirst { it == STONE }
                val nextCube = remaining.indexOfFirst { it == CUBE }
                if (nextCube == -1 || nextStone < nextCube) {
                    sortedList.swap(i, nextStone + i)
                }
            }
        }
        return sortedList
    }

    private fun <T> List<List<T>>.transpose(): List<List<T>> =
        if (isEmpty()) emptyList()
        else (0 until this[0].size).map { col -> map { it[col] } }

    private fun MutableList<String>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }

    companion object {
        const val STONE = "O"
        const val CUBE = "#"
        const val SPACE = "."
    }

}