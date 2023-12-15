
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day14")
class Day14Test {

    private val testData = resourceAsListOfString("Day14_test.txt")
    private val realData = resourceAsListOfString("Day14_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day14(testData).solvePart1()
            assertThat(answer).isEqualTo(136)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day14(realData).solvePart1()
            assertThat(answer).isEqualTo(109_466)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day14(testData).solvePart2()
            println(answer)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day14(realData).solvePart2()
            println(answer)
        }
    }

}