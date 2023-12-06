
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 6")
class Day06Test {

    private val testData = resourceAsListOfString("Day06_test.txt")
    private val realData = resourceAsListOfString("Day06_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day06(testData).solvePart1()
            assertThat(answer).isEqualTo(288)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day06(realData).solvePart1()
            assertThat(answer).isEqualTo(140220)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day06(testData).solvePart2()
            assertThat(answer).isEqualTo(71503)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day06(realData).solvePart2()
            assertThat(answer).isEqualTo(39570185)
        }
    }

}