
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day15")
class Day15Test {

    private val testData = resourceAsString("Day15_test.txt")
    private val realData = resourceAsString("Day15_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day15(testData).solvePart1()
            assertThat(answer).isEqualTo(1_320)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day15(realData).solvePart1()
            assertThat(answer).isEqualTo(503_154)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day15(testData).solvePart2()
            assertThat(answer).isEqualTo(145)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day15(realData).solvePart2()
            assertThat(answer).isEqualTo(251_353)
        }
    }

}