package org.jglynn.aoc

import kotlin.math.pow

class Day05(private val input: List<String>) {

    fun solvePart1(): Long {

        val seeds = parseSeeds(input)
        val rangeMappings = parseRanges(input)
        val minLocation = seeds.minOf { seed ->
            rangeMappings.fold(seed) { acc, ranges ->
                ranges.destination(acc)
            }
        }
        return minLocation
    }

    fun solvePart2(): Int {
        return input.size
    }

    private fun parseSeeds(input: List<String>) =
        input.first().substringAfter(":").trim().split(" ").map { it.toLong() }

    private fun parseRanges(input: List<String>): List<List<Pair<LongRange,LongRange>>> =
        input.drop(2).joinToString("\n").split("\n\n").map {
            it.split("\n").drop(1).map { line -> line.toRanges() }
        }

    private fun List<Pair<LongRange,LongRange>>.destination(source: Long): Long {
        this.forEach{ range ->
            if (range.second.contains(source)) {
                return range.first.elementAt(range.second.indexOf(source))
            }
        }
        return source
    }

    // 50 98 2
    private fun String.toRanges(): Pair<LongRange,LongRange> {
        val (source, destination, range) = this.trim().split(" ").map { it.toLong() }
        return source..(source + range) to destination ..(destination + range)
    }

}
