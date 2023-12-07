
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day07")
class Day07Test {

    private val testData = resourceAsListOfString("Day07_test.txt")
    private val realData = resourceAsListOfString("Day07_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day07(testData).solvePart1()
            assertThat(answer).isEqualTo(6440)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day07(realData).solvePart1()
            assertThat(answer).isEqualTo(251058093)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day07(testData).solvePart2()
            println(answer)
        }

        @Test
        fun `Actual answer`() {
            val answer = Day07(realData).solvePart2()
            println(answer)
        }
    }

}