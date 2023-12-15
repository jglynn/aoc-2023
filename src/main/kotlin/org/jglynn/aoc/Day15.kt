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
        val boxes = List(256){ mutableMapOf<String, Int>() }

        input.split(",").forEach {
            if (it.contains("-")) {
                val label = it.substringBefore("-")
                boxes[label.hash()].remove(label)
            } else {
                val label = it.substringBefore("=")
                val lens = it.substringAfter("=").toInt()
                boxes[label.hash()][label] = lens
            }
        }

        val focusPower = boxes.mapIndexed { boxNumber, box ->
            box.values.withIndex().sumOf {
                    (slot, focalLength) -> (boxNumber+1) * (slot+1) * focalLength }
        }.sum()

        return focusPower
    }

}