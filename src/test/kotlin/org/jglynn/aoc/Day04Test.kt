
package org.jglynn.aoc

import org.assertj.core.api.Assertions.assertThat
import org.jglynn.aoc.Utils.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 4")
class Day04Test {

    private val testData = resourceAsListOfString("Day04_test.txt")
    private val realData = resourceAsListOfString("Day04_real.txt")

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {

            val answer = Day04(testData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(13)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day04(realData).solvePart1()

            // Assert
            assertThat(answer).isEqualTo(21138)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {

            val answer = Day04(testData).solvePart2()
            println("Answer = $answer")
            assertThat(answer).isEqualTo(30)
        }

        @Test
        fun `Actual answer`() {

            val answer = Day04(realData).solvePart2()
            println("Answer = $answer")
            assertThat(answer).isEqualTo(7185540)

        }
    }


}