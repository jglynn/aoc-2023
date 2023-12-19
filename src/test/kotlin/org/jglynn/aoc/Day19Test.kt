
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day19")
class Day19Test {

    private val testData = resourceAsString("Day19_test.txt")
    private val realData = resourceAsString("Day19_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day19(testData).solvePart1()
            assertThat(answer).isEqualTo(19_114)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day19(realData).solvePart1()
            assertThat(answer).isEqualTo(434_147)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day19(testData).solvePart2()
            assertThat(answer).isEqualTo(0)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day19(realData).solvePart2()
            assertThat(answer).isEqualTo(0)
        }
    }

}